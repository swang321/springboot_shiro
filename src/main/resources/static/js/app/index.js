var $breadcrumb = $(".breadcrumb");
var $main_content = $(".main-content");
var $navigation = $("#navigation");

$(window).on("load", function () {
    // 加载loading
    setTimeout(function () {
        $(".page-loader").fadeOut();
    }, 500)
}),


    $(document).ready(function () {

        //使用递归处理菜单
        var str = "";
        var forTree = function (o) {
            for (var i = 0; i < o.length; i++) {
                var urlstr = "";
                try {
                    if (!o[i]["url"]) {
                        urlstr = "<div><span>&nbsp;&nbsp;" + o[i]["text"] + "</span><ul>";
                    } else {
                        urlstr = "<div><span name=" + o[i]["url"] + " onclick='loadMain(this);'>&nbsp;&nbsp;" + o[i]["text"] + "</span><ul>";
                    }
                    str += urlstr;
                    if (o[i]["children"] !== null) {
                        forTree(o[i]["children"]);
                    }
                    str += "</ul></div>";
                } catch (e) {
                    console.log(e);
                }
            }
            return str;
        };

        var menuTree = function () {
            $navigation.find("ul").each(function (index, element) {
                var ulContent = $(element).html();
                var spanContent = $(element).siblings("span").html();
                if (ulContent) {
                    $(element).siblings("span").html(spanContent)
                }
            });
            $navigation.find("div span").click(function () {
                var ul = $(this).siblings("ul").hide(300);
                if (ul.find("div").html() != null) {
                    if (ul.css("display") === "none") {
                        ul.show(300);
                    } else {
                        ul.hide(300);
                    }
                }
            });
            $navigation.find("div>span").click(function () {
                var ul = $(this).parent().siblings().find(">ul");
                ul.hide(300);
            })
        };
        $.post("permission/loadMenu", function (r) {
            if (r.code === 0) {
                var data = r.data;
                var $crollbarInner = $(".scrollbar-inner");
                document.getElementById("navigation").innerHTML = forTree(data.children);
                menuTree();
                $crollbarInner[0] && $crollbarInner.scrollbar().scrollLock()
            } else {
                $MB.n_danger(r.msg);
            }
        })

    }),


//     $(document).ready(function () {
//     // 修改个人信息
//     $(".user__img").attr("src", avatar);
//     $("#user__profile").on('click', function () {
//         $.post(ctx + "user/profile", function (r) {
//             $breadcrumb.html("").append('<li class="breadcrumb-item">个人信息</li>');
//             $main_content.html("").append(r);
//         });
//     });
// });

    /**
     * 用于加载菜单内容
     * @param obj
     */
    loadMain = function (obj) {
        console.log("------------")
        // 设置面包屑
        var $this = $(obj);
        $(".navigation").find("span").removeClass("navigation__active");
        $this.addClass("navigation__active").parents("ul").prev().addClass("navigation__active");

        var breadcrumnHtml = "";
        var target_text = $this.text();
        var text_arr = [];
        var parent = $this.parents("ul").prev().each(function () {
            var $this = $(this);
            text_arr.unshift($this.text());
        });
        for (var i = 0; i < text_arr.length; i++) {
            breadcrumnHtml += '<li class="breadcrumb-item">' + text_arr[i] + '</li>';
        }
        breadcrumnHtml += '<li class="breadcrumb-item">' + target_text + '</li>';
        $breadcrumb.html("").append(breadcrumnHtml);

        // 加载内容
        var $name = $this.attr("name");
        console.log($name)
        $.post($name, {}, function (r) {
            $main_content.html("").append(r);
        });
    };



