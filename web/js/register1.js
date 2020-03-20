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

//判断是否全为数字
function numb(str) {
    var reg= /^[0-9]+$/;
    var result=reg.test(str);
    return result;
}
//手机号验证，11位，正确的是手机号开头位13*，15*，18*
function isPhone(str){
    var reg=new RegExp("^((13[0-9])|(15[0-9])|(18[0-9]))\\d{8}$");
    var result=reg.test(str);
    return result;
}


// 验证
window.onload = function() {
    // 获取对象
    var phNumber = document.getElementById("phNumber");
    var phNumberLength = 0;
    var phName = document.getElementById("phName");
    var phNameLength = 0;
    var phPwd = document.getElementById("phPwd");
    var phPwdLength = 0;
    var phPwd2 = document.getElementById('phPwd2');
    var phID = document.getElementById("phID");
    var phIDLength=0;
    var phID2 = document.getElementById("phID2");
    var phID2Length=0;
    var phPhone = document.getElementById("phPhone");
    var phAddr=document.getElementById("phAddr");
    var phAddrLength=0;
    var error= document.getElementById("error");
    var register = document.getElementById("reg");
    // 对账号进行验证
    phNumber.onkeyup = function() {
        if (!number(this.value)) {
            error.innerHTML = '<a style="color: orangered;">账号中含有除数字和字母之外的非法字符</a>';
        }
        else {
            phNumberLength = getLength(this.value);
            if (phNumberLength < 4) {
                error.innerHTML = "当前" + phNumberLength + "个字符，"+'<a style="color: orangered;">账号名过短</a>';
            } else if (phNumberLength <= 20) {
                error.innerHTML = "当前" + phNumberLength + "个字符，账号名格式正确";
            } else {
                error.innerHTML = "当前" + phNumberLength + "个字符，"+'<a style="color: orangered;">账号名过长</a>';
            }
        }
    }
    //对姓名进行验证
    phName.onkeyup=function(){
        phNameLength = getLength(this.value);
        if (phNameLength < 4) {
            error.innerHTML = "当前" + phNameLength + "个字符，"+'<a style="color: orangered;">姓名过短</a>';
        } else if (phNameLength <= 20) {
            error.innerHTML = "当前" + phNameLength + "个字符，姓名格式正确";
        } else {
            error.innerHTML = "当前" + phNameLength + "个字符，"+'<a style="color: orangered;">姓名过长</a>';
        }

    }
    // 对密码进行验证
    phPwd.onkeyup = function() {
        phPwdLength = getLength(this.value);
        if(phPwdLength < 4) {
            error.innerHTML = "当前" + phPwdLength + "个字符，"+'<a style="color: orangered;">密码过短</a>';
            phPwd2.setAttribute('disabled', "");
        }
        else if(phPwdLength <= 20) {
            error.innerHTML = "当前" + phPwdLength + "个字符，密码正常";
            phPwd2.removeAttribute('disabled');
        }
        else {
            error.innerHTML = "当前" + phPwdLength + "个字符，"+'<a style="color: orangered;">密码过长</a>';
            phPwd2.setAttribute('disabled', "");
        }
    }


    // 对重复输入的密码进行验证
    phPwd2.onkeyup = function() {
        if(this.value == phPwd1.value) {
            error.innerHTML = "输入正确!";
        }
        else {
            error.innerHTML = '<a style="color: orangered;">两次密码输入不匹配!</a>';
        }
    }
    //对身份证号进行验证
    phID.onkeyup=function(){
        if (!numb(this.value)) {
            error.innerHTML = '<a style="color: orangered;">身份证号中含有非法字符</a>';
        }
        else {
            phIDLength = getLength(this.value);
            if (phIDLength < 18) {
                error.innerHTML = "当前" + phIDLength + "个字符，"+'<a style="color: orangered;">身份证号过短</a>';
                phID2.setAttribute('disabled', "");
            } else if (phIDLength = 18) {
                error.innerHTML = "当前" + phIDLength + "个字符，身份证号格式正确";
                phID2.removeAttribute('disabled');
            } else {
                error.innerHTML = "当前" + phIDLength + "个字符，"+'<a style="color: orangered;">身份证号过长</a>';
                phID2.setAttribute('disabled', "");
            }
        }
    }
    //对重复身份证号进行验证
    phID2.onkeyup=function(){
        if(this.value == phID.value) {
            error.innerHTML = "输入正确!";
            register.removeAttribute('disabled');
        }
        else {
            error.innerHTML = '<a style="color: orangered;">两次身份证输入不匹配!</a>';
            register.setAttribute('disabled',"");
        }
    }
    //对电话号码进行验证
    phPhone.onkeyup=function(){
        if(isPhone(this.value)){
            error.innerHTML = '手机号码正确';
        }else{
            error.innerHTML = '<a style="color: orangered;">您输入的电话格式有误</a>';
        }
    }

    //对地址进行验证
    phAddr.onkeyup=function(){
        phAddrLength = getLength(this.value);
        if (phAddrLength < 4) {
            error.innerHTML = "当前" + phAddrLength + "个字符，"+'<a style="color: orangered;">地址过短</a>';
        } else if (phAddrLength <= 50) {
            error.innerHTML = "当前" + phAddrLength + "个字符，地址格式正确";
        } else {
            error.innerHTML = "当前" + phAddrLength + "个字符，"+'<a style="color: orangered;">地址过长</a>';
        }
    }
}