layui.config({
    base: '/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
    , citypicker: '{/}/layui_exit/js/city_picker'
}).use(['index','citypicker'], function () {
    var $ = layui.$
        , admin = layui.admin
        , element = layui.element
        , layer = layui.layer;

// 根据区县唯一标示得到省市区地址
    var p1 = ChineseDistricts[86]['A-G'];
    var p2 = ChineseDistricts[86]['H-K'];
    var p3 = ChineseDistricts[86]['L-S'];
    var p4 = ChineseDistricts[86]['T-Z'];
    function getAddressByProvinceCode(provinceCode, p) {
        var province = '';
        for (var i = 0; i < p.length; i++) {
            if (provinceCode == p[i].code) {
                province = p[i].address;
                break;
            }
        }
        return province;
    }
    function getByDistrict(districtCode) {
        var province = '';
        var city = '';
        var district = '';
        try {
            var provinceCode = parseInt(districtCode / 10000) * 10000;
            var cityCode = parseInt(districtCode / 100) * 100;
            city = ChineseDistricts[provinceCode][cityCode];
            district = ChineseDistricts[cityCode][districtCode];
            var isFound = 0;
            if (isFound == 0) {
                province = getAddressByProvinceCode(provinceCode, p1);
                if (province != '') {
                    isFound = 1;
                }
            }
            if (isFound == 0) {
                province = getAddressByProvinceCode(provinceCode, p2);
                if (province != '') {
                    isFound = 1;
                }
            }
            if (isFound == 0) {
                province = getAddressByProvinceCode(provinceCode, p3);
                if (province != '') {
                    isFound = 1;
                }
            }
            if (isFound == 0) {
                province = getAddressByProvinceCode(provinceCode, p4);
                if (province != '') {
                    isFound = 1;
                }
            }
        } catch (err) {
            console.log(err);
        }
        return province+"-"+city+"-"+district;
    }
    $("#address").text(getByDistrict($("#district").val()));



    /* 触发弹层 */
    var active = {
        data: function () {
            layer.open({
                type: 2,
                title: '更改账号信息',
                area: ['600px', '400px'],
                btn: ['确定', '取消'],
                fixed: false,
                btnAlign: 'c',
                maxmin: true,
                content: '/school/data?schoolimg='+$("#schoolimg").attr('src')+'&schoolname='+$("#schoolname").text(),
                yes: function (index, layero) {
                    //点击确认触发 iframe 内容中的按钮提交
                    var submit = layero.find('iframe').contents().find("#layuiadmin-app-form-submit");
                    submit.click();
                }
            });
        },
        dataAll: function () {
            layer.open({
                type: 2,
                title: '更改账号所有人资料',
                area: ['600px', '400px'],
                btn: ['确定', '取消'],
                fixed: false,
                btnAlign: 'c',
                maxmin: true,
                content: '/school/dataAll?phone='+$("#yc_school_phone").text()+'&address='+ $("#address").text(),
                yes: function (index, layero) {
                    //点击确认触发 iframe 内容中的按钮提交
                    var submit = layero.find('iframe').contents().find("#layuiadmin-app-form-submit");
                    submit.click();
                }
            });
        }
    };


    $('.layui-icon-edit').on('click', function () {
        var type = $(this).data('type');
        active[type] && active[type].call(this);
    });

    function updateData(text, index) {
        if (index == 1) {//学校名称
            $.ajax({
                type: 'POST'
                , dataType: 'json'
                , url: '/school/updateData'
                , data: {schoolname: text}
                , success: (function (result) {
                    if (result.code == 200) {
                        layer.msg(result.msg, {
                            offset: '15px'
                            , icon: 1
                            , time: 1000
                        }, function () {
                            location.reload();
                        })
                    } else {
                        layer.msg(result.msg,{icon:5});
                    }
                })
            })
        } else {//手机号
            alert(1111)
            $.ajax({
                type: 'POST'
                , dataType: 'json'
                , url: '/school/updateData'
                , data: {phone: text}
                , success: (function (result) {
                    if (result.code == 200) {
                        location.reload();
                    } else {
                        layer.msg(result.msg);
                    }
                })
            })
        }
    }
});