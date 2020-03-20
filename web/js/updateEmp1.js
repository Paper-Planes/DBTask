// 计算字符串 str 的长度
function getLength(str) {
    return str.replace(/[^\x00-xff]/g, "xx").length;
}
//判断是否全为数字和字母
function number(str) {
    //var reg=/^[0-9]+$/;
    var reg= /^[0-9a-zA-Z]+$/;
    var result=reg.test(str);
    return result;
}

// 验证
window.onload = function() {
    // 获取对象
    // var empNo = document.getElementById("empNo");
    // var empNoLength = 0;
    // var empNoMsg = document.getElementById("empNoMsg");
    var empName = document.getElementById("empName");
    var empNameLength = 0;
    var empNameMsg = document.getElementById("empNameMsg");
    var empPwd1 = document.getElementById("empPwd1");
    var empPwd1Length = 0;
    var empPwd1Msg = document.getElementById("empPwd1Msg");
    var empPwd2 = document.getElementById('empPwd2');
    var empPwd2Msg = document.getElementById('empPwd2Msg');
    var register = document.getElementById("reg");
    // 对职工账号进行验证
    // empNo.onkeyup = function() {
    //     if (!number(this.value)) {
    //         empNoMsg.innerHTML = '<a style="color: orangered;">账号中含有除数字和字母之外的非法字符</a>';
    //     }
    //     else {
    //         empNoLength = getLength(this.value);
    //         if (empNoLength < 4) {
    //             empNoMsg.innerHTML = "当前" + empNoLength + "个字符，"+'<a style="color: orangered;">账号名过短</a>';
    //         } else if (empNoLength <= 20) {
    //             empNoMsg.innerHTML = "当前" + empNoLength + "个字符，账号名格式正确";
    //         } else {
    //             empNoMsg.innerHTML = "当前" + empNoLength + "个字符，"+'<a style="color: orangered;">账号名过长</a>';
    //         }
    //     }
    // }
    //对职工姓名进行验证
    empName.onkeyup=function(){
        empNameLength = getLength(this.value);
        if (empNameLength < 4) {
            empNameMsg.innerHTML = "当前" + empNameLength + "个字符，"+'<a style="color: orangered;">姓名过短</a>';
        } else if (empNameLength <= 20) {
            empNameMsg.innerHTML = "当前" + empNameLength + "个字符，姓名格式正确";
        } else {
            empNameMsg.innerHTML = "当前" + empNameLength + "个字符，"+'<a style="color: orangered;">姓名过长</a>';
        }

    }
    // 对密码进行验证
    empPwd1.onkeyup = function() {
        empPwd1Length = getLength(this.value);
        if(empPwd1Length < 4) {
            empPwd1Msg.innerHTML = "当前" + empPwd1Length + "个字符，"+'<a style="color: orangered;">密码过短</a>';
            empPwd2.setAttribute('disabled', "");
        }
        else if(empPwd1Length <= 20) {
            empPwd1Msg.innerHTML = "当前" + empPwd1Length + "个字符，密码正常";
            empPwd2.removeAttribute('disabled');
        }
        else {
            empPwd1Msg.innerHTML = "当前" + empPwd1Length + "个字符，"+'<a style="color: orangered;">密码过长</a>';
            empPwd2.setAttribute('disabled', "");
        }
    }


    // 对重复输入的密码进行验证
    empPwd2.onkeyup = function() {
        if(this.value == phPwd1.value) {
            empPwd2Msg.innerHTML = "输入正确!";
            register.removeAttribute('disabled');
        }
        else {
            empPwd2Msg.innerHTML = '<a style="color: orangered;">两次密码输入不匹配!</a>';
            register.setAttribute('disabled', "");
        }
    }
}