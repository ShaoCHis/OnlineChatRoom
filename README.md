# OnlineChatRoom
21年秋，Web系统与技术实现的在线聊天网站

## 系统功能
该在线聊天网站实现了较为全面的功能（其中聊天功能模拟腾讯会议的聊天框）
```
其中用xxx来表示发送的消息内容；id用来表示用户的id
1｜登陆/注册：用户可以进行注册和登录；登陆的用户名后续会作为聊天室的昵称，保持唯一性
1｜在线聊天；所有人登陆后，进入公共群聊，发送消息均为所有人可见；发送消息格式为=>groupChat:xxxx
2｜修改个人信息：用户可以对个人信息进行修改，同时聊天框的左侧会显示个人信息
2｜添加/删除好友：用户可以通过输入好友的昵称进行好友的添加和删除，不用通过（单方面进行即可）
2｜私聊好友：由于公共群聊的公开性，增加了好友私聊的功能；用户可以选择进行私聊
```

## 前端
- 前端采用完整的html、css、js三大件完成
- 接口调用使用XMLHTTPREQUEST()进行请求的封装调用
- 在设计CSS时，尽可能避免了绝对长度和绝对位置；大的组件部分使用相对位置进行布置，小组件使用绝对位置进行小幅度调整
- 同时，使用了小部分的jquery的写法，来进行页面跳转之间的传值操作

## 技术
由于完全要求其采用原生HTML进行项目的开发，所以HTML、CSS、JS的编写可能并不成熟，可能存在编码冗余等问题

```
聊天室采用WebSocket进行通讯
1｜在网页进行加载时，即生命周期函数Created()时，进行socket对服务器的连接，也就是握手操作
2｜在判断浏览器是否支持后，成功建立连接，即可进行消息的收发操作
3｜onopen，在建立连接后即调用该函数，可在控制台查看输出信息
4｜onmessage，使用onmessage对WebSocket服务端对客户端的通信进行接收
5｜onerror，在发生错误（客户端或者服务端）时调用，断开连接
6｜onclose，断开与服务端的连接
```

### Some Tips
```
1｜在接收消息与发送消息时，对与接收方进行了判断，仅允许好友之间进行私聊
2｜使用二进制流消息对文件进行发送，目前仅实现了图片的发送与还原（任何文件都可以发送，但只实现了图片文件的还原）
3｜对于接收的消息进行了部分的处理
```
```
跨域问题未在代码中解决，因为服务器部署可以使用nginx解决跨域问题，所以代码中未解决，如需跨域请参照以下教程：
以Chrome为例：
   windows下：
      C:\Users\Administrator\AppData\Local\Google\Chrome\Application\chrome.exe --disable-web-security --user-data-dir=C:\Program Files (x86)\Google\Chrome\Application
      将文件目录替换为自己的文件目录，主要修改为--disable～（关闭谷歌的跨域）
   macOS/Linux下：
      在一个文件目录下创建一个Chrome的文件夹，然后使用指令open -n /Applications/Google\ Chrome.app/ --args --disable-web-security  --user-data-            dir=/Users/shentao/Documents/MyChrome，将dir=后面的文件目录替换为自己新建的Chrome文件目录即可
```
