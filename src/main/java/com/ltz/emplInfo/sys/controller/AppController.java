package com.ltz.emplInfo.sys.controller;

import com.ltz.emplInfo.common.vo.AppResult;
import com.ltz.emplInfo.common.vo.Result;
import com.ltz.emplInfo.sys.entity.EmplInfo;
import com.ltz.emplInfo.sys.entity.EmplInfoCheck;
import com.ltz.emplInfo.sys.entity.EmplNews;
import com.ltz.emplInfo.sys.entity.Graduate;
import com.ltz.emplInfo.sys.service.IEmplInfoCheckService;
import com.ltz.emplInfo.sys.service.IEmplInfoService;
import com.ltz.emplInfo.sys.service.IEmplNewsService;
import com.ltz.emplInfo.sys.service.IGraduateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.*;

import static com.ltz.emplInfo.util.Convert.convertEmplInfo;
import static com.ltz.emplInfo.util.Convert.convertEmplInfoCheck;

@RestController
@RequestMapping("/api/app")
public class AppController {
    private Integer code = 0;
    @Autowired
    private IGraduateService graduateService;
    @Autowired
    private IEmplNewsService emplNewsService;
    @Autowired
    private IEmplInfoCheckService emplInfoCheckService;
    @Autowired
    private IEmplInfoService emplInfoService;


    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader("token");
        if (token == null) return;
        code = 0;
        if (!check(token)) {
            code = 401;
        }
    }

    private boolean check(String token) {
        Map<String, Object> data = graduateService.getGraduateInfo(token);
        return data != null;
    }


    // App登录
    @PostMapping("/login")
    public AppResult<Object> login(@RequestBody Graduate graduate) {
        String token = graduateService.login(graduate);
        AppResult<Object> result = new AppResult<>();
        if (token != null) {
            result.setCode(20000);
            result.setMsg("success");
            result.setExpire(12);
            result.setData(token);
            Map<String, Object> data = graduateService.getGraduateInfo(token);
            result.setPage(data);
        } else {
            result.setCode(20002);
            result.setMsg("账号or密码错误");
            result.setExpire(0);
            result.setData(null);
        }
        return result;
    }

    @PostMapping("/logout")
    public AppResult<?> logout(@RequestHeader("token") String token) {
        graduateService.logout(token);
        AppResult<Object> result = new AppResult<>();
        result.setCode(20000);
        return result;
    }


    @GetMapping("/getEmplNewsByPage")
    public AppResult<Map<String, Object>> getAllEmplNewsByPage(@RequestParam("pageNum") int pageNum,
                                                               @RequestParam("pageSize") int pageSize) {
        AppResult<Map<String, Object>> result = new AppResult<>();
        if (code == 401) {
            result.setCode(401);
        } else {
            List<EmplNews> allEmplNews = emplNewsService.list();
            // 排序（显示最新）
            Collections.sort(allEmplNews);
            Map<String, Object> page = new HashMap<>();
            // 计算当前页的起始索引和结束索引
            int startIndex = (pageNum - 1) * pageSize;
            int endIndex = Math.min(startIndex + pageSize, allEmplNews.size());

            int totalCount = allEmplNews.size();
            int totalPage = (totalCount + pageSize - 1) / pageSize;
            List<EmplNews> currentPageEmplNews = allEmplNews.subList(startIndex, endIndex);
            page.put("totalCount", totalCount);
            page.put("totalPage", totalPage);
            page.put("pageSize", pageSize);
            page.put("pageNum", pageNum);
            page.put("list", currentPageEmplNews);
            result.setCode(20000);
            result.setPage(page);  // 单页
            result.setMsg("第 " + pageNum + " 页的结果");
        }
        return result;
    }

    @GetMapping("/getEmplNewsBySearch")
    public Result<List<EmplNews>> getEmplNewsBySearch(@RequestParam("keyword") String keyword) {
        Result<List<EmplNews>> result = new Result<>();
        if (code == 401) {
            result.setCode(401);
        } else {
            List<EmplNews> list = emplNewsService.getEmplNewsBySearch(keyword);
            result.setData(list);
            result.setTotal(list.size());
            result.setCode(20000);
            result.setMessage("搜索到" + list.size() + "条结果");
        }
        return result;
    }

    @PostMapping("/add")
    public Result<String> addCheck(@RequestBody EmplInfoCheck emplInfoCheck) {
        convertEmplInfoCheck(emplInfoCheck);
        boolean added = emplInfoCheckService.add(emplInfoCheck);
        if (added) {
            return Result.success("成功");
        } else {
            return Result.fail("失败");
        }
    }

    // 重新提交，把原来的删了
    @PostMapping("/reAdd")
    public Result<String> reAddCheck(@RequestBody EmplInfoCheck emplInfoCheck) {
        convertEmplInfoCheck(emplInfoCheck);
        boolean deleted = emplInfoCheckService.delete(emplInfoCheck.getStudentId());
        if (deleted) {
            return Result.success("成功");
        } else {
            return Result.fail("失败");
        }
    }

    // 根据完整学号精确查找
    @GetMapping("/getByStudentId")
    public Result<?> getByStudentId(@RequestParam("studentId") String studentId) {
        Result<EmplInfoCheck> result = new Result<>();
        if (code == 401) {
            result.setCode(401);
        } else {
            List<EmplInfo> list = emplInfoService.getEmplInfoBySearch(studentId);
            if (list.size() == 0) {
                result.setCode(20002);
            } else {
                return getEmplInfoByStudentId(studentId);
            }
            EmplInfoCheck info = emplInfoCheckService.getByStudentId(studentId);
            if (info == null) {
                result.setCode(20003);
            } else {
                result.setData(info);
                result.setCode(20001);
            }
        }
        return result;
    }

    public Result<EmplInfo> getEmplInfoByStudentId(String studentId) {
        Result<EmplInfo> result = new Result<>();
        if (code == 401) {
            result.setCode(401);
        } else {
            List<EmplInfo> list = emplInfoService.getEmplInfoBySearch(studentId);
            for (EmplInfo info : list) {
                convertEmplInfo(info);
            }
            result.setData(list.get(0));
            result.setCode(20000);

        }
        return result;
    }

}
