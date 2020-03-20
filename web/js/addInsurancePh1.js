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
    var iNo = document.getElementById("iNo");
    var iNoLength = 0;
    var iNoMsg = document.getElementById("iNoMsg");
    var empNo = document.getElementById("empNo");
    var empNoLength = 0;
    var empNoMsg = document.getElementById("empNoMsg");
// 对保单号进行验证
    iNo.onkeyup = function() {
        if (!number(this.value)) {
            iNoMsg.innerHTML = '<a style="color: orangered;">账号中含有除数字和字母之外的非法字符</a>';
        }
        else {
            iNoLength = getLength(this.value);
            if (iNoLength < 3) {
                iNoMsg.innerHTML = "当前" + iNoLength + "个字符，"+'<a style="color: orangered;">账号名过短</a>';
            } else if (iNoLength <= 20) {
                iNoMsg.innerHTML = "当前" + iNoLength + "个字符，账号名格式正确";
            } else {
                iNoMsg.innerHTML = "当前" + iNoLength + "个字符，"+'<a style="color: orangered;">账号名过长</a>';
            }
        }
    }

    //对员工进行验证
    empNo.onkeyup = function() {
        if (!number(this.value)) {
            empNoMsg.innerHTML = '<a style="color: orangered;">账号中含有除数字和字母之外的非法字符</a>';
        }
        else {
            empNoLength = getLength(this.value);
            if (empNoLength < 4) {
                empNoMsg.innerHTML = "当前" + empNoLength + "个字符，"+'<a style="color: orangered;">账号名过短</a>';
            } else if (empNoLength <= 20) {
                empNoMsg.innerHTML = "当前" + empNoLength + "个字符，账号名格式正确";
            } else {
                empNoMsg.innerHTML = "当前" + empNoLength + "个字符，"+'<a style="color: orangered;">账号名过长</a>';
            }
        }
    }

}