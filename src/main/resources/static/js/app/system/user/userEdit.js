function updateUser() {
    var selected = $("#userTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要修改的用户！');
        return;
    }
    if (selected_length > 1) {
        $MB.n_warning('一次只能修改一个用户！');
        return;
    }
    var userId = selected[0].userId;
    $.post("user/getUser", {"userId": userId}, function (r) {
        if (r.code === 0) {
            var $form = $('#user-add');
            $form.modal();
            var user = r.data;
            $form.find(".user_password").hide();
            $("#user-add-modal-title").html('修改用户');
            $form.find("input[name='username']").val(user.username).attr("readonly", true);
            $form.find("input[name='userId']").val(user.userId);
            // var roleArr = [];
            // for (var i = 0; i < user.roleids.length; i++) {
            //     roleArr.push(user.roleids[i]);
            // }
            // $form.find("select[name='rolesSelect']").multipleSelect('setSelects', roleArr);
            $form.find("input[name='roles']").val($form.find("select[name='rolesSelect']").val());
            var $status = $form.find("input[name='status']");
            if (user.status === '1') {
                $status.prop("checked", true);
                $status.parent().next().html('可用');
            } else {
                $status.prop("checked", false);
                $status.parent().next().html('禁用');
            }
            // $("input:radio[value='" + user.ssex + "']").prop("checked", true);
            // $deptTree.jstree().open_all();
            // $deptTree.jstree('select_node', user.deptId, true);
            $("#user-add-button").attr("name", "update");
        } else {
            $MB.n_danger(r.msg);
        }
    });
}