<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>华发物业ERP</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="static/layui/css/layui.css">
    <link rel="stylesheet" href="static/css/login.css" media="all" />
</head>


<section class="top-center-bottom">
    <style type="text/css">
        .top-center-bottom{
            width: 100%;
            height:100%;
            display: flex;
            flex-direction: column;
        }
        .top{
            width: 100%;
            height: 100px;
            /*background: yellow;*/
        }
        .bottom{
            width: 100%;
            flex: 1;
            height: 100%;
            /*background: #49a094;*/
        }
        /*.center{*/
        /*height: 800px;*/
        /*width: 100%;*/
        /*background: #ff3c4a;*/
        /*}*/
    </style>
    <div class="top">
        <img src="static/images/logo.png" style="margin-left: 20%;margin-top: 20px;float: left">
        <p style="margin-top: 20px"><font size="6">&nbsp&nbsp&nbsp&nbspERP信息管理系统</font></p>
        <#--<h1 style="margin-top: 24px">ERP信息管理系统</h1>-->
    </div>
    <div class="center">
        <form class="layui-form" action="/dologin" method="post">
            <input name="username" placeholder="请输入账号" class="name" required />
            <input name="password" placeholder="请输入密码" class="password" type="password" required />
            <button class="layui-btn login_btn" lay-submit="" lay-filter="login">登录</button>
        </form>
    </div>
    <div class="bottom">
        <div style="margin-left:40%;margin-top: 50px">© 2019 珠海华发物业管理服务有限公司 版权所有</div>
    </div>
</section>

</body>
<script type="text/javascript" src="static/layui/layui.js"></script>
<script type="text/javascript" src="static/jquery/jquery.min.js"></script>
<script>
    $(function() {
        if (self.location != top.location) {
            top.location = self.location;
        }
    });

    layui.use(['layer', 'form'], function() {
        var layer = layui.layer,
            $ = layui.jquery,
            form = layui.form;

        $("#mycode").on('click',function(){
            var t = Math.random();
            $("#mycode")[0].src="/genCaptcha?t= "+t;
        });

        form.on('submit(login)', function(data) {
            var loadIndex = layer.load(2, {
                shade: [0.3, '#333']
            });
            // if($('form').find('input[type="checkbox"]')[0].checked){
            //     data.field.rememberMe = true;
            // }else{
            data.field.rememberMe = false;
            // }
            var param = {
                userName:data.field.username,
                passWord:data.field.password
            };
            $.ajax({
                type: 'POST',
                url: data.form.action,
                data: JSON.stringify(param),
                headers:{'Content-Type':'application/json;charset=utf8'},
                success: function(res) {
                    layer.close(loadIndex);
                    if(res.code == 200){
                        location.href="/"+res.data;
                    }else{
                        layer.msg(res.msg);
                        $("#mycode").click();
                    }
                },
                dataType: "json"
            });
            return false;
        });
    });
</script>
</html>