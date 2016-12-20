/**
 * Created by yuying on 2016/12/19.
 */

function fnLogin()
{
    $.post("/LoginService",{mail:$("#txt_email").val(),password:$("#txt_password").val()},function (json) {
        if(json.state=="ok"){
            location.href='/main';
        }
        else
        {
            alert(json.msg);
        }
    },"json");
}
