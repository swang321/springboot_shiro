$(function () {
    initTreeTable();
});

function initTreeTable() {
    var $menuTableForm = $(".menu-table-form");
    var setting = {
        id: 'menuId',
        code: 'menuId',
        url: 'permission/list',
        expandAll: true,
        expandColumn: "2",
        ajaxParams: {
            permission: $menuTableForm.find("input[name='menuName']").val().trim(),
            resourceType: $menuTableForm.find("select[name='type']").val()
        },
        columns: [
            {
                field: 'selectItem',
                checkbox: true
            },
            {
                title: '编号',
                field: 'menuId',
                width: '50px'
            },
            {
                title: '名称',
                field: 'menuName'
            },
            {
                title: '类型',
                field: 'type',
                formatter: function (item, index) {
                    if (item.type === '0') return '<span class="badge badge-success">菜单</span>';
                    if (item.type === '1') return '<span class="badge badge-warning">按钮</span>';
                }

            },
            {
                title: '地址',
                field: 'url',
                formatter: function (item, index) {
                    return item.url === 'null' ? '' : item.url;
                }
            },
            {
                title: '权限标识',
                field: 'perms',
                formatter: function (item, index) {
                    return item.perms === 'null' ? '' : item.perms;
                }
            }
        ]
    };

    $MB.initTreeTable('menuTable', setting);
}

function search() {
    initTreeTable();
}

function refresh() {
    $(".menu-table-form")[0].reset();
    initTreeTable();
    $MB.refreshJsTree("menuTree", createMenuTree());
}

function deleteMenus() {
    var ids = $("#menuTable").bootstrapTreeTable("getSelections");
    var ids_arr = "";
    if (!ids.length) {
        $MB.n_warning("请勾选需要删除的菜单或按钮！");
        return;
    }
    for (var i = 0; i < ids.length; i++) {
        ids_arr += ids[i].id;
        if (i !== (ids.length - 1)) ids_arr += ",";
    }
    $MB.confirm({
        text: "确定删除选中菜单或按钮？",
        confirmButtonText: "确定删除"
    }, function () {
        $.post('menu/delete', {"ids": ids_arr}, function (r) {
            if (r.code === 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}

