> 登录 注册 找回密码

1. /login  post提交方式 {username:, password, grant_type:password, client_id:road_safe, client_secret:123456, scope:all}

        return example {"access_token":"403192bd-b0d3-4bae-be9b-396e59b0c0da","token_type":"bearer","refresh_token":"d333a9d2-6bac-4a47-aee5-ce77b5fd2973","expires_in":5867,"scope":"all"}

2. /register post提交方式 {userName:, userPwd:} result 是 userId

        {"result":"0412452c-c2df-3400-beff-c430c01164b8","response":"200","data":{"access_token":"a1db3ed7-d344-4ade-94f0-52ea63cf94a3","token_type":"bearer","refresh_token":"44dbfcad-d363-4363-8491-58cc9c1a2dce","expires_in":43199,"scope":"all"}}

3. /findPWD get提交方式


> 获取算法结果

1. /api/{user_id}/