package com.ltz.emplInfo.sys.controller;

import com.ltz.emplInfo.common.vo.Result;
import com.ltz.emplInfo.sys.entity.Admin;
import com.ltz.emplInfo.sys.entity.Permission;
import com.ltz.emplInfo.sys.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tianzhi
 * @since 2024-03-07
 */
@RestController
@RequestMapping("/api/permission")
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;

    @PostMapping("/getMenu/{roleId}")
    public List<Permission> getMenu(@PathVariable("roleId") Integer roleId){
        List<Permission> permissions = permissionService.getMenu(roleId);
        List<Permission> data = new ArrayList<>();

        List<Integer> parent_id = new ArrayList<>();
        List<Permission> childrenList = new ArrayList<>();

        // 遍历Permission对象列表获取没有children的项
        for (Permission permission : permissions) {
            if (permission.getParentId() != 0 ) {
                // 有children的项的parent_id集合
                parent_id.add(permission.getParentId());
                // 将所有children的项添加到childrenList中
                childrenList.add(permission);
            }
        }
        // 将childrenList按照parent_id分组存在childrenMap
        Map<Integer, List<Permission>> childrenMap = new HashMap<>();
        for (int parentId : parent_id) {
            List<Permission> children = new ArrayList<>();
            for (Permission child : childrenList) {
                if (child.getParentId() == parentId) {
                    children.add(child);
                }
            }
            childrenMap.put(parentId, children);
        }
        // 去除parent_id的重复值，方便从childrenMap中获取数据
        HashSet<Integer> set = new HashSet<>(parent_id);
        List<Integer> list = new ArrayList<>(set);
        // 将分组存在对应的children中
        for (Permission permission : permissions) {
            for (Integer id:list) {
                if (Objects.equals(permission.getId(), id)) {
                    permission.setChildren(childrenMap.get(id));
                    data.add(permission);
                }
            }
            if (permission.getParentId() == 0 &&  permission.getChildren() == null) {
                data.add(permission);
            }
        }

        return data;

    }
}
