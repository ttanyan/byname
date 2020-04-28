<%@ page contentType="text/html;charset=gbk" language="java" %>
<html >
<head>
</head>
<body>
<style>
    html,body,div,p{margin:0;padding:0}
    body{font-size:14px;font-family:"microsoft yahei";background-color:#ffffff}
    table{border-collapse:collapse;border-spacing:0;table-layout:fixed}
    th,td{font-size:14px;padding:0}
    a{text-decoration:none}
    img{border:0 none}
    .blue{text-decoration:none;color:#3c3d5d}
    .chead{width:1002px}
    .chead .logo{width:698px;height:90px}
    .chead .txt{width:152px;height:90px}
    .column{width:1002px;line-height:28px;border:1px solid #dedede}
    .column .hbox{width:185px;height:154px}
    .column .head{display:block;background-color:#fafafa}
    .column .box{width:100%;background-color:#ffffff;border-top:2px solid #f2f3f5}
    .column .box1{width:100%;word-wrap:break-word;color:#ffffff;background-color:#3f4160}
    .column .box2{width:100%;background-color:#f8f9fa}
    .column .tba{width:940px;padding:0 30px 15px}
    .column .tbb{width:940px;padding:0 30px}
    .column .tb1{width:900px;line-height:28px;color:#333333;word-break:break-all;padding:0 20px}
    .column .tb2{width:430px;padding:0 20px}
    .column .tb3{width:900px;padding:15px 20px 15px 0}
    .column .gray,.column .gray2{color:#999999;word-break:break-all}
    .column .gray2{color:#666666}
    .column .plate1,.column .plate2{width:430px;height:54px;font-size:16px;font-weight:bold;color:#818ba3}
    .column .plate1{width:900px;padding:0 50px}
    .column .plate1 .f16{font-size:14px;font-weight:normal;color:#333333}
    .column .plate1 .f12{font-size:12px;font-weight:normal;color:#999999}
    .column .keys,.column .keys2{width:85px;line-height:28px;color:#666666}
    .column .keys2{width:110px}

    .column .txt1,.column .txt2,.column .txt3{width:815px;line-height:28px;color:#333333;word-break:break-all}
    .column .txt2{width:345px}
    .column .txt3{width:auto;max-width:815px;font-size:14px;font-weight:bold}
    .column .txt4{width:305px;color:#ffffff;word-break:break-all}
    .column .infr{width:767px;color:#ffffff;table-layout:auto}
    .column .vam,.column .grcha{vertical-align:middle;margin-left:5px}
    .column .box1 .vam{margin-right:5px;margin-left:0}
    .column .name{font-size:24px;padding-bottom:18px}
    .column .comment{font-size:2mm;padding-bottom:58px}
    .column .icard{color:#a1a3ae;padding-bottom:18px}
    .column .con{border-top:1px dotted #ddd}
    .column .pr20{width:225px;padding-right:20px}
    .column .time{width:120px;line-height:28px;color:#666666;padding-left:20px}
    .column .rtbox{width:765px;line-height:28px;color:#333333;padding:0 20px 0 15px;word-break:break-all}
    .column .hai,.column .guan{line-height:18px;font-size:12px;color:#ffffff;vertical-align:text-top;margin-left:5px;padding:1px 3px;background-color:#3cbe7f;border-radius:2px}
    .column .guan{background-color:#ff9f20}
    .column .tag{display:inline-block;word-break:break-all;#display:inline;#zoom:1}
    .column .all{color:#666;padding:10px 20px;background-color:#fafafa}
    .column .tit{width:900px;height:40px;color:#666666;padding:0 20px;background-color:#f5f5f5}
    .column .p15{padding:15px 0}
    .column .p5{display:inline-block;color:#666666;padding:0 5px;#display:inline;#zoom:1}
    .column .cell .skill{width:165px;text-align:right;padding-right:15px}
    .column .cell .skbg,.column .cell .skco{display:inline-block;width:245px;height:18px;line-height:18px;font-size:12px;color:#ffffff;vertical-align:top;margin-top:6px;background-color:#dddddd;border-radius:20px;#display:inline;#zoom:1}
    .column .cell .skco{width:235px;font-style:normal;margin-top:0;padding-left:10px;background-color:#ff9f20;z-index:3}
    .column .sl .skco{width:173px}
    .column .lh .skco{width:112px}
    .column .yb .skco{width:51px}
    .column .fbox strong{font-size:14px;font-weight:bold}
    .column .cha{font-size:12px;font-weight:normal;color:#00457d;margin-left:5px}
    .column .cha:hover{color:#ff6000}
    .column .email{width:330px}

    .eng td,.eng .txt3,.eng .fbox strong{font-size:13px;font-family:'Arial'}
    .eng .txt1,.eng .rtbox,.eng .phd{width:775px;font-size:13px;font-family:'Arial';line-height:28px}
    .eng .txt2{width:305px}
    .eng .txt4{width:245px}
    .eng .cell .txt3{width:120px}
    .eng .time,.eng .keys{width:110px;font-size:13px;text-align:right}
    .eng .cell .skill{width:130px}
    .eng .phd{padding-left:145px}
    .eng .keys{padding-right:15px}
    .eng .pr20{width:205px}
    .eng .pr20 .keys{width:100px}
    .eng .email{width:270px}
</style>
<table cellpadding="0" cellspacing="0" align="center" bgcolor="#fff" class="column">
    <tbody >
        <tr>
            <td valign="top">
                <!--基本信息-->
                <table cellspacing="0" cellpadding="0" border="0" class="box1">
                    <tbody>
                        <tr>
                            <td class="hbox" align="middle">
                                <img src="https://i.51job.com/resume/ajax/image.php?type=avatar&userid=379830840&1585321623&key=fa702bab7eebd05eebeccfc37260a93c" width="85" height="104" class="head" alt="头像">
                            </td>
                            <td>
                                <table cellspacing="0" cellpadding="0" border="0" class="infr">
                                    <tbody>
                                        <tr>
                                            <td colspan="2" class="name">谭连旺</td>
                                            <td  class="comment">复制头部网址查看效果最佳&#8593</td>
                                        </tr>
                                        <tr>
                                            <td valign="top">
                                                <img class="vam" src="https://img01.51jobcdn.com/im/2016/resume/y1.png" width="20" height="20" />目前正在找工作                                            </td>
                                                                                            <td valign="top">
                                                    <img class="vam" src="https://img01.51jobcdn.com/im/2016/resume/y2.png" width="20" height="20" />15736517656                                                </td>
                                                                                                                                        <td valign="top">
                                                    <table cellspacing="0" cellpadding="0" border="0" class="email">
                                                    <tbody>
                                                        <tr>
                                                        <td valign="top" width="25">
                                                            <img class="vam" src="https://img01.51jobcdn.com/im/2016/resume/y3.png" width="20" height="20" />
                                                        </td>
                                                        <td valign="top" class="txt4">tanlianwang@qq.com</td>
                                                        </tr>
                                                    </tbody>
                                                    </table>
                                                </td>
                                                                                    </tr>
                                        <tr>
                                            <td valign="top" colspan="3">
                                                <p>
                                                <img class="vam" src="https://img01.51jobcdn.com/im/2016/resume/y4.png" width="20" height="20" />男<span class="p5">|</span>23 岁<span class="p5">  | </span>现居住 重庆<span class="p5">|</span>2年工作经验                                                </p>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <!--最近工作-->
                                    <table cellspacing="0" cellpadding="0" border="0" class="box2">
                        <tbody>
                            <tr>
                            <td class="tba">
                                <table cellspacing="0" cellpadding="0" border="0">
                                    <tbody>
                                        <tr>
                                        <td valign="top" class="tb2">
                                            <table cellspacing="0" cellpadding="0" border="0">
                                            <thead style="height:0">
                                                <tr>
                                                <td valign="top" class="keys"></td>
                                                <td valign="top" class="txt2"></td>
                                                </tr>
                                                    </thead>
                                                    <tbody>
                                                                                                                <tr>
                                                            <td colspan="2" class="plate2">最近工作</td>
                                                        </tr>
                                                        <tr>
                                                            <td valign="top" class="keys">职位：</td>
                                                            <td valign="top" class="txt2">java开发工程师</td>
                                                        </tr>
                                                        <tr>
                                                            <td valign="top" class="keys">公司：</td>
                                                            <td valign="top" class="txt2">深圳几米物联有限公司</td>
                                                        </tr>
                                                        <tr>
                                                            <td valign="top" class="keys">行业：</td>
                                                            <td valign="top" class="txt2">物联网/大数据</td>
                                                        </tr>
                                                    </tbody>
                                            </table>
                                        </td>
                                        <td valign="top" class="tb2">
                                            <table cellspacing="0" cellpadding="0" border="0">
                                                <thead style="height:0">
                                                    <tr>
                                                        <td valign="top" class="keys"></td>
                                                        <td valign="top" class="txt2"></td>
                                                    </tr>
                                                </thead>
                                                                                                <tbody>
                                                    <tr>
                                                        <td colspan="2" class="plate2">最高学历/学位</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top" class="keys">专业：</td>
                                                        <td valign="top" class="txt2">物联网工程</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top" class="keys">学校：</td>
                                                        <td valign="top" class="txt2">大连民族大学</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top" class="keys">学历/学位：</td>
                                                        <td valign="top" class="txt2">本科</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </td>
                            </tr>
                        </tbody>
                    </table>
                                <!--个人信息-->
                                    <table cellspacing="0" cellpadding="0" border="0" class="box">
                        <tbody>
                            <tr>
                                <td class="plate1">个人信息</td>
                            </tr>
                            <tr>
                                <td class="tba">
                                    <table cellspacing="0" cellpadding="0" border="0">
                                        <tbody>
                                                                                    <tr>
                                                                                                                                                    <td class="tb2" valign="top">
                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                        <tbody>
                                                            <tr>
                                                            <td valign="top" class="keys">户口/国籍：</td>
                                                            <td valign="top" class="txt2">重庆</td>
                                                            </tr>
                                                        </tbody>
                                                        </table>
                                                    </td>
                                                                                                                                                    <td class="tb2" valign="top">&nbsp;</td>
                                                                                            </tr>
                                                                                                                            <tr>
                                                                                                    <td class="tb2" valign="top">
                                                    </td>
                                                                                                                                                    <td class="tb2" valign="top">
                                                    </td>
                                                                                                                                            </tr>
                                                                                                                            <tr>
                                                                                                    <td class="tb2" valign="top">
                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                        <tbody>
                                                            <tr>
                                                                <td valign="top" class="keys">家庭住址：</td>
                                                                <td valign="top" class="txt2">重庆市开州区                                                                                                                                            (邮编：405412)
                                                                                                                                    </td>
                                                            </tr>
                                                        </tbody>
                                                        </table>
                                                    </td>
                                                                                                                                                    <td class="tb2" valign="top">
                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                        <tbody>
                                                            <tr>
                                                            <td valign="top" class="keys">政治面貌：</td>
                                                            <td valign="top" class="txt2">共青团员</td>
                                                            </tr>
                                                        </tbody>
                                                        </table>
                                                    </td>
                                                                                                                                            </tr>
                                                                                                                            <tr>
                                                <td class="tb1" colspan="2">
                                                    <table cellspacing="0" cellpadding="0" border="0" >
                                                        <thead style="height:0">
                                                            <tr>
                                                                <td valign="top" class="keys"></td>
                                                                <td valign="top" class="txt1"></td>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <tr>
                                                                <td valign="top" class="keys">Github</td>
                                                                <td valign="top" class="txt1"><a target="_blank" class="cha" href="https://github.com/ttanyan" >https://github.com/ttanyan</a></td>

                                                                <td valign="top" class="keys">CSDN</td>
                                                                <td valign="top" class="txt1"><a target="_blank" class="cha" href="https://blog.csdn.net/tingfengqianqu" >https://blog.csdn.net/tingfengqianqu</a></td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </td>
                                            </tr>
                                                                                </tbody>
                                    </table>
                                </td>
                            </tr>
                        </tbody>
                    </table>

                                <!--求职意向-->
                                    <table cellspacing="0" cellpadding="0" border="0" class="box">
                        <tbody>
                        <tr>
                            <td class="plate1">求职意向</td>
                        </tr>
                        <tr>
                            <td class="tba">
                            <table cellspacing="0" cellpadding="0" border="0">
                                <tbody>
                                                                            <tr>
                                            <td class="tb1" colspan="2">
                                                <table cellspacing="0" cellpadding="0" border="0">
                                                    <thead style="height:0">
                                                        <tr>
                                                        <td valign="top" class="keys"></td>
                                                        <td valign="top" class="txt1"></td>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td valign="top" class="keys">个人标签：</td>
                                                            <td valign="top" class="txt1">
                                                                                                                            <span class="tag">物联网&nbsp;</span>
                                                                                                                            <span class="tag">java开发&nbsp;</span>
                                                                                                                            <span class="tag">MySQL&nbsp;</span>
                                                                                                                            <span class="tag">运维&nbsp;</span>
                                                                                                                            <span class="tag">软件测试</span>
                                                                                                                        </td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
                                                                                                                <tr>
                                                                                                                                        <td class="tb2" valign="top">
                                                    <table cellspacing="0" cellpadding="0" border="0">
                                                        <tbody>
                                                            <tr>
                                                                <td valign="top" class="keys">地点：</td>
                                                                <td valign="top" class="txt2">
                                                                                                                                        <span class="tag">重庆&nbsp;</span>
                                                                                                                                        <span class="tag">成都&nbsp;</span>
                                                                                                                                        <span class="tag">武汉&nbsp;</span>
                                                                                                                                        <span class="tag">深圳</span>
                                                                                                                                    </td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </td>
                                                                                                                                </tr>
                                                                                                                <tr>
                                                                                            <td class="tb2" valign="top">
                                                    <table cellspacing="0" cellpadding="0" border="0">
                                                        <tbody>
                                                            <tr>
                                                                <td valign="top" class="keys">职能/职位：</td>
                                                                <td valign="top" class="txt2">
                                                                                                                                                                                                                        <span class="tag">Java开发工程师</span>
                                                                                                                                                <span class="tag">&nbsp;&nbsp;运维开发、测试开发</span>
                                                                                                                                    </td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </td>
                                                                                                                                        <td class="tb2" valign="top">
                                                    <table cellspacing="0" cellpadding="0" border="0">
                                                    <tbody>
                                                        <tr>
                                                        <td valign="top" class="keys">行业：</td>
                                                        <td valign="top" class="txt2">
                                                                                                                            <span class="tag">
                                                                    计算机软件                                                                </span>
                                                                                                                    </td>
                                                        </tr>
                                                    </tbody>
                                                    </table>
                                                </td>
                                                                                                                                </tr>
                                                                                                                <tr>
                                                                                            <td class="tb2" valign="top">
                                                    <table cellspacing="0" cellpadding="0" border="0">
                                                    <tbody>
                                                        <tr>
                                                        <td valign="top" class="keys">到岗时间：</td>
                                                        <td valign="top" class="txt2">随时</td>
                                                        </tr>
                                                    </tbody>
                                                    </table>
                                                </td>
                                                                                                                                    <td class="tb2" valign="top">
                                                <table cellspacing="0" cellpadding="0" border="0">
                                                <tbody>
                                                    <tr>
                                                    <td valign="top" class="keys">工作类型：</td>
                                                    <td valign="top" class="txt2">全职</td>
                                                    </tr>
                                                </tbody>
                                                </table>
                                            </td>
                                                                                                                                </tr>
                                                                                                                <tr>
                                        <td class="tb1" colspan="2">
                                            <table cellspacing="0" cellpadding="0" border="0">
                                            <thead style="height:0">
                                                <tr>
                                                <td valign="top" class="keys"></td>
                                                <td valign="top" class="txt1"></td>
                                                </tr>
                                            </thead>
                                            </table>
                                        </td>
                                        </tr>
                                                                    </tbody>
                            </table>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                                <!--工作经验-->
                                    <table cellspacing="0" cellpadding="0" border="0" class="box">
                        <tbody>
                            <tr>
                                <td class="plate1">工作经验</td>
                            </tr>
                            <tr>
                                <td class="tbb">
                                    <table cellspacing="0" cellpadding="0" border="0">
                                                                                                                            <tr>
                                                                                            <td class="p15">
                                                                                                <table cellspacing="0" cellpadding="0" border="0">
                                                        <tbody>
                                                            <tr>
                                                                <td valign="top" class="time">2018/11-2019/12</td>
                                                                <td valign="top" class="rtbox">
                                                                    <strong class="txt3">Java开发工程师</strong><span class="p5">|</span><span>平台运营事业部</span>                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td class="phd tb1" colspan="2">
                                                                    <span>深圳几米物联有限公司</span><span class="gray">&nbsp;[1年1个月]</span>
                                                                </td>
                                                            </tr>
                                                                                                                            <tr>
                                                                    <td class="phd tb1 gray2" colspan="2">物联网/GPS定位<span class="p5">|</span>1000人以上<span class="p5">|</span>民营公司</td>
                                                                </tr>
                                                                                                                                                                                        <tr>
                                                                    <td class="tb1" colspan="2">
                                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>
                                                                                    <td valign="top" class="keys">工作描述：</td>
                                                                                    <td valign="top" class="txt1">1、负责车派达项目的设计开发<br>2、负责途强风控平台的线上运维以及迭代开发<br>3、负责途强平台的线上维护</td>
                                                                                </tr>
                                                                            </tbody>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                                                                                                                                                </tbody>
                                                    </table>
                                                </td>
                                            </tr>
                                                                                                                    </table>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                                <!-- 项目经验 -->
                                    <table cellspacing="0" cellpadding="0" border="0" class="box">
                        <tbody>
                            <tr>
                                <td class="plate1">项目经验</td>
                            </tr>
                            <tr>
                                <td class="tba">
                                    <table cellspacing="0" cellpadding="0" border="0">
                                                                                                                            <tr>
                                                                                                    <td class="p15">
                                                                                                    <table cellspacing="0" cellpadding="0" border="0">
                                                        <tbody>
                                                            <tr>
                                                                <td valign="top" class="time">2019/1-2019/12</td>
                                                                <td valign="top" class="rtbox">
                                                                    <strong>车派达</strong>
                                                                </td>
                                                            </tr>
                                                                                                                            <tr>
                                                                    <td class="tb1" colspan="2">
                                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>
                                                                                    <td valign="top" class="keys">所属公司：</td>
                                                                                    <td valign="top" class="txt1">深圳几米物联有限公司</td>
                                                                                </tr>
                                                                            </tbody>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                                                                                                                                                        <tr>
                                                                    <td class="tb1" colspan="2">
                                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>
                                                                                    <td valign="top" class="keys">项目描述：</td>
                                                                                    <td valign="top" class="txt1">车派达主要为风控平台服务，解决设备安装流程中商家派达和安装公司接单的需求。系统包括帐号管理、金   额、订单管理以及订单展示等模块。整个项目比较简单，完全由我们应届生开发，采用了Springboot框架开发，中间件用了MQ和MySQL。</td>
                                                                                </tr>
                                                                            </tbody>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                                                                                                                                                        <tr>
                                                                    <td class="tb1" colspan="2">
                                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>
                                                                                    <td valign="top" class="keys">责任描述：</td>
                                                                                    <td valign="top" class="txt1">本人在这个项目中主要的收获是对MySQL和MyBatis语句更加熟练，并且负责自己开发的模块功能测试和性能测试。在测试过程不断的优化自己的代码使我的技术得到了很快的成长。</td>
                                                                                </tr>
                                                                            </tbody>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                                                                                    </tbody>
                                                    </table>
                                                </td>
                                            </tr>
                                                                                    <tr>
                                                                                                    <td class="p15">
                                                                                                    <table cellspacing="0" cellpadding="0" border="0">
                                                        <tbody>
                                                            <tr>
                                                                <td valign="top" class="time">2019/1-2019/11</td>
                                                                <td valign="top" class="rtbox">
                                                                    <strong>途强风控平台</strong>
                                                                </td>
                                                            </tr>
                                                                                                                            <tr>
                                                                    <td class="tb1" colspan="2">
                                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>
                                                                                    <td valign="top" class="keys">所属公司：</td>
                                                                                    <td valign="top" class="txt1">深圳几米物联有限公司</td>
                                                                                </tr>
                                                                            </tbody>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                                                                                                                                                        <tr>
                                                                    <td class="tb1" colspan="2">
                                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>
                                                                                    <td valign="top" class="keys">项目描述：</td>
                                                                                    <td valign="top" class="txt1">途强平台主要是基于GPS定位的车辆服务平台，包含设备管理、用户管理、控制台、统计报表这几个模块等，这个平台主要包含Pass和Sass两部分，Pass主要提供设备网关、数据处理、接口查询。设备消息主要使用ActiveMQ进行订阅和推送，数据存储通过Redis、MongoDB、MySQL等进行存储。为Sass提供HTTP和RPC接口查询数据。用到了Zookeeper和Dubbo。Sass端主要使用SpringCloud微服务架构，通过eureka注册与发现从而实现服务之间的调用。与Pass之间除接口交互数据之外还通过canal实现MySQL数据库同步，将告警数据写入ES中。</td>
                                                                                </tr>
                                                                            </tbody>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                                                                                                                                                        <tr>
                                                                    <td class="tb1" colspan="2">
                                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>
                                                                                    <td valign="top" class="keys">责任描述：</td>
                                                                                    <td valign="top" class="txt1">本人主要负责的是Sass端业务层的需求实现以及项目线上部署和运维。在这个项目中学习了Linux的操作以及Shell和Python的基本用法，能够编写一些脚本用于线上运维和部署。学习了项目中所有的中间件的安装以及使用，了解了他们的各自的特点。</td>
                                                                                </tr>
                                                                            </tbody>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                                                                                    </tbody>
                                                    </table>
                                                </td>
                                            </tr>
                                                                                    <tr>
                                                                                                    <td class="p15">
                                                                                                    <table cellspacing="0" cellpadding="0" border="0">
                                                        <tbody>
                                                            <tr>
                                                                <td valign="top" class="time">2018/11-2019/1</td>
                                                                <td valign="top" class="rtbox">
                                                                    <strong>途强平台</strong>
                                                                </td>
                                                            </tr>
                                                                                                                            <tr>
                                                                    <td class="tb1" colspan="2">
                                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>
                                                                                    <td valign="top" class="keys">所属公司：</td>
                                                                                    <td valign="top" class="txt1">深圳几米物联有限公司</td>
                                                                                </tr>
                                                                            </tbody>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                                                                                                                                                        <tr>
                                                                    <td class="tb1" colspan="2">
                                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>
                                                                                    <td valign="top" class="keys">项目描述：</td>
                                                                                    <td valign="top" class="txt1">途强平台主要是基于GPS定位的车辆服务平台，包含设备管理、用户管理、控制台、统计报表这几个模块，其中控制台主要是利用设备定位信息为车辆提供位置服务，包含轨迹回放、车辆追踪状态统计、指令发送等。统计报表主要是从车辆的运行里程、设备的状态以及告警数据这三个维度进行统计，包含告警统计、运动统计、设备统计。</td>
                                                                                </tr>
                                                                            </tbody>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                                                                                                                                                        <tr>
                                                                    <td class="tb1" colspan="2">
                                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>
                                                                                    <td valign="top" class="keys">责任描述：</td>
                                                                                    <td valign="top" class="txt1">本人主要是在导师的指导下学习项目开发的流程以及公司的业务需求，独自写一些单元测试以及数据库的设计。</td>
                                                                                </tr>
                                                                            </tbody>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                                                                                    </tbody>
                                                    </table>
                                                </td>
                                            </tr>
                                                                            </table>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                                <!--教育经历-->
                                    <table class="box">
                        <tbody>
                            <tr>
                                <td class="plate1">教育经历</td>
                            </tr>
                            <tr>
                                <td class="tba">
                                    <table cellspacing="0" cellpadding="0" border="0">
                                                                                                                            <tr>
                                                                                                    <td class="p15">
                                                                                                    <table cellspacing="0" cellpadding="0" border="0">
                                                        <tbody>
                                                            <tr>
                                                                <td valign="top" class="time">2015/9-2019/6</td>
                                                                <td valign="top" class="rtbox">
                                                                    <strong>大连民族大学</strong>                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td class="tb1" colspan="2">本科<span class="p5">|</span>物联网工程                                                                </td>
                                                            </tr>
                                                                                                                            <tr>
                                                                    <td class="tb1" colspan="2">
                                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>
                                                                                    <td valign="top" class="keys">主修课程：</td>
                                                                                    <td valign="top" class="txt1">C语言、Java、Java Web、HTML/CSS/JavaScript、MySQL、数据结构、计算机网络、软件工程导论、Python、单片机、传感器、传感器网络、嵌入式（UC/OS-II）</td>
                                                                                </tr>
                                                                            </tbody>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                                                                                    </tbody>
                                                    </table>
                                                </td>
                                            </tr>
                                                                                                                    </table>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                                <!--在校情况-->
                                    <table cellspacing="0" cellpadding="0" border="0" class="box">
                        <tbody>
                            <tr>
                                <td class="plate1">在校情况</td>
                            </tr>
                            <tr>
                                <td class="tbb">
                                <!--校内荣誉-->
                                                                    <table cellspacing="0" cellpadding="0" border="0">
                                        <tbody>
                                            <tr>
                                                <td class="tit">校内荣誉</td>
                                            </tr>
                                                                                                                                        <tr>
                                                                                                        <td class="tb3">
                                                                                                            <table cellspacing="0" cellpadding="0" border="0">
                                                            <tbody>
                                                                <tr>
                                                                    <td valign="top" class="time">2018/9</td>
                                                                    <td valign="top" class="rtbox">
                                                                        <strong class="txt3">国家励志奖学金</strong>
                                                                                                                                            </td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </td>
                                                </tr>
                                                                                                                                        <tr>
                                                                                                        <td class="tb3 con">
                                                                                                            <table cellspacing="0" cellpadding="0" border="0">
                                                            <tbody>
                                                                <tr>
                                                                    <td valign="top" class="time">2017/10</td>
                                                                    <td valign="top" class="rtbox">
                                                                        <strong class="txt3">软件著作权两项</strong>
                                                                                                                                            </td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </td>
                                                </tr>
                                                                                                                                        <tr>
                                                                                                        <td class="tb3 con">
                                                                                                            <table cellspacing="0" cellpadding="0" border="0">
                                                            <tbody>
                                                                <tr>
                                                                    <td valign="top" class="time">2017/10</td>
                                                                    <td valign="top" class="rtbox">
                                                                        <strong class="txt3">全国移动互联网创新大赛</strong>
                                                                                                                                                    <span>（二等奖）</span>
                                                                                                                                            </td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </td>
                                                </tr>
                                                                                                                                        <tr>
                                                                                                        <td class="tb3 con">
                                                                                                            <table cellspacing="0" cellpadding="0" border="0">
                                                            <tbody>
                                                                <tr>
                                                                    <td valign="top" class="time">2017/9</td>
                                                                    <td valign="top" class="rtbox">
                                                                        <strong class="txt3">I CAN国际创新创业大赛</strong>
                                                                                                                                                    <span>（三等奖）</span>
                                                                                                                                            </td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </td>
                                                </tr>
                                                                                                                                        <tr>
                                                                                                        <td class="tb3 con">
                                                                                                            <table cellspacing="0" cellpadding="0" border="0">
                                                            <tbody>
                                                                <tr>
                                                                    <td valign="top" class="time">2017/9</td>
                                                                    <td valign="top" class="rtbox">
                                                                        <strong class="txt3">全国大学生物联网设计竞赛（TI)杯</strong>
                                                                                                                                                    <span>（一等奖）</span>
                                                                                                                                            </td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </td>
                                                </tr>
                                                                                                                                        <tr>
                                                                                                        <td class="tb3 con">
                                                                                                            <table cellspacing="0" cellpadding="0" border="0">
                                                            <tbody>
                                                                <tr>
                                                                    <td valign="top" class="time">2017/4</td>
                                                                    <td valign="top" class="rtbox">
                                                                        <strong class="txt3">全国大学生互联网软件设计大奖赛</strong>
                                                                                                                                                    <span>（三等奖）</span>
                                                                                                                                            </td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </td>
                                                </tr>
                                                                                                                                        <tr>
                                                                                                        <td class="tb3 con">
                                                                                                            <table cellspacing="0" cellpadding="0" border="0">
                                                            <tbody>
                                                                <tr>
                                                                    <td valign="top" class="time">2016/9</td>
                                                                    <td valign="top" class="rtbox">
                                                                        <strong class="txt3">国家级大学生创新创业大赛</strong>
                                                                                                                                            </td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </td>
                                                </tr>
                                                                                                                                </tbody>
                                    </table>
                                                                    </td>
                            </tr>
                        </tbody>
                    </table>
                                <!--技能特长-->
                                    <table cellspacing="0" cellpadding="0" border="0" class="box">
                        <tbody>
                            <tr>
                                <td class="plate1">
                                技能特长                                    <span class="f12">（包含IT技能、证书）</span>
                                </td>
                            </tr>
                            <tr>
                                <td class="tbb">
                                    <!--技能/语言-->
                                                                            <table cellspacing="0" cellpadding="0" border="0">
                                            <tbody>
                                                <tr>
                                                    <td class="tit">技能/语言</td>
                                                </tr>
                                                <tr>
                                                    <td class="p15">
                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                            <tbody>
                                                                                                                                                                                                                                                                        <tr>
                                                                                                                                                                                                                    <td class="tb2 cell sl" valign="top">
                                                                                                                                                    <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>
                                                                                <td class="skill">
                                                                                    <strong class="txt3">Web前端</strong>
                                                                                </td>
                                                                                <td valign="top">
                                                                                    <span class="skbg">
                                                                                    <span class="skco">熟练</span>
                                                                                    </span>
                                                                                </td>
                                                                                </tr>
                                                                            </tbody>
                                                                            </table>
                                                                        </td>
                                                                                                                                                                                                                                                                                                                                                                                                                        <td class="tb2 cell sl" valign="top">
                                                                                                                                                    <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>
                                                                                <td class="skill">
                                                                                    <strong class="txt3">C/C++</strong>
                                                                                </td>
                                                                                <td valign="top">
                                                                                    <span class="skbg">
                                                                                    <span class="skco">熟练</span>
                                                                                    </span>
                                                                                </td>
                                                                                </tr>
                                                                            </tbody>
                                                                            </table>
                                                                        </td>
                                                                                                                                        </tr>
                                                                                                                                                                                                                                                                                                                                            <tr>
                                                                                                                                                                                                                    <td class="tb2 cell sl" valign="top">
                                                                                                                                                    <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>
                                                                                <td class="skill">
                                                                                    <strong class="txt3">MS VISIO</strong>
                                                                                </td>
                                                                                <td valign="top">
                                                                                    <span class="skbg">
                                                                                    <span class="skco">熟练</span>
                                                                                    </span>
                                                                                </td>
                                                                                </tr>
                                                                            </tbody>
                                                                            </table>
                                                                        </td>
                                                                                                                                                                                                                                                                                                                                                                                                                        <td class="tb2 cell sl" valign="top">
                                                                                                                                                    <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>
                                                                                <td class="skill">
                                                                                    <strong class="txt3">JavaScript</strong>
                                                                                </td>
                                                                                <td valign="top">
                                                                                    <span class="skbg">
                                                                                    <span class="skco">熟练</span>
                                                                                    </span>
                                                                                </td>
                                                                                </tr>
                                                                            </tbody>
                                                                            </table>
                                                                        </td>
                                                                                                                                        </tr>
                                                                                                                                                                                                                                                                                                                                            <tr>
                                                                                                                                                                                                                    <td class="tb2 cell sl" valign="top">
                                                                                                                                                    <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>
                                                                                <td class="skill">
                                                                                    <strong class="txt3">HTML5</strong>
                                                                                </td>
                                                                                <td valign="top">
                                                                                    <span class="skbg">
                                                                                    <span class="skco">熟练</span>
                                                                                    </span>
                                                                                </td>
                                                                                </tr>
                                                                            </tbody>
                                                                            </table>
                                                                        </td>
                                                                                                                                                                                                                                                                                                                                                                                                                        <td class="tb2 cell sl" valign="top">
                                                                                                                                                    <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>
                                                                                <td class="skill">
                                                                                    <strong class="txt3">Android</strong>
                                                                                </td>
                                                                                <td valign="top">
                                                                                    <span class="skbg">
                                                                                    <span class="skco">熟练</span>
                                                                                    </span>
                                                                                </td>
                                                                                </tr>
                                                                            </tbody>
                                                                            </table>
                                                                        </td>
                                                                                                                                        </tr>
                                                                                                                                                                                                                                                                                                                                            <tr>
                                                                                                                                                                                                                    <td class="tb2 cell sl" valign="top">
                                                                                                                                                    <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>
                                                                                <td class="skill">
                                                                                    <strong class="txt3">Java</strong>
                                                                                </td>
                                                                                <td valign="top">
                                                                                    <span class="skbg">
                                                                                    <span class="skco">熟练</span>
                                                                                    </span>
                                                                                </td>
                                                                                </tr>
                                                                            </tbody>
                                                                            </table>
                                                                        </td>
                                                                                                                                                                                                                                                                                                                                                                                                                        <td class="tb2 cell sl" valign="top">
                                                                                                                                                    <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>
                                                                                <td class="skill">
                                                                                    <strong class="txt3">SQL</strong>
                                                                                </td>
                                                                                <td valign="top">
                                                                                    <span class="skbg">
                                                                                    <span class="skco">熟练</span>
                                                                                    </span>
                                                                                </td>
                                                                                </tr>
                                                                            </tbody>
                                                                            </table>
                                                                        </td>
                                                                                                                                        </tr>
                                                                                                                                                                                                                                                                </tbody>
                                                        </table>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                                                        <!--证书-->
                                                                            <table cellspacing="0" cellpadding="0" border="0">
                                            <tbody>
                                                <tr>
                                                    <td class="tit">证书扫描件</td>
                        <tr>
                            <td class="tbb">
                                <!--测评报告-->
                                                                <!--附件-->
                                                                    <table cellspacing="0" cellpadding="0" border="0">
                                        <tbody>

                                                                                                                                        <tr>
                                                                                                        <td class="p15">
                                                                                                            <table cellspacing="0" cellpadding="0" border="0">
                                                            <tbody>
                                                                <tr>
                                                                    <td class="tb1">
                                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>

                                                                                        <td valign="top" class="txt3">
                                                                                            <strong>全国大学生物联网设计竞赛｜一等奖</strong>
                                                                                                                                                                                            <a target="_blank" class="cha" href="https://i.51job.com/resume/ajax/image.php?type=image&userid=379830840&attachid=45989031&key=fa702bab7eebd05eebeccfc37260a93c" >查看&gt;</a>
                                                                                                                                                                                    </td>
                                                                                </tr>
                                                                                                                                                                                                                                            </tbody>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </td>
                                                </tr>
                                                                                                                                        <tr>
                                                                                                        <td class="p15 con">
                                                                                                            <table cellspacing="0" cellpadding="0" border="0">
                                                            <tbody>
                                                                <tr>
                                                                    <td class="tb1">
                                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>

                                                                                        <td valign="top" class="txt3">
                                                                                            <strong>飞鸽APP软件著作权</strong>
                                                                                                                                                                                            <a target="_blank" class="cha" href="https://i.51job.com/resume/ajax/image.php?type=image&amp;userid=379830840&amp;attachid=46171009&amp;key=fa702bab7eebd05eebeccfc37260a93c" >查看&gt;</a>
                                                                                                                                                                                    </td>
                                                                                </tr>
                                                                                                                                                                                                                                            </tbody>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </td>
                                                </tr>
                                                                                                                                        <tr>
                                                                                                        <td class="p15 con">
                                                                                                            <table cellspacing="0" cellpadding="0" border="0">
                                                            <tbody>
                                                                <tr>
                                                                    <td class="tb1">
                                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>

                                                                                        <td valign="top" class="txt3">
                                                                                            <strong>iCan国际创新创业大赛｜三等奖</strong>
                                                                                                                                                                                            <a target="_blank" class="cha" href="https://i.51job.com/resume/ajax/image.php?type=image&amp;userid=379830840&amp;attachid=46171004&amp;key=fa702bab7eebd05eebeccfc37260a93c" >查看&gt;</a>
                                                                                                                                                                                    </td>
                                                                                </tr>
                                                                                                                                                                                                                                            </tbody>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </td>
                                                </tr>
                                                                                                                                        <tr>
                                                                                                        <td class="p15 con">
                                                                                                            <table cellspacing="0" cellpadding="0" border="0">
                                                            <tbody>
                                                                <tr>
                                                                    <td class="tb1">
                                                                        <table cellspacing="0" cellpadding="0" border="0">

                                                                                    <td valign="top" class="txt3">
                                                                                          <strong>飞鸽APP演示视频</strong>
                                                                                        <a target="_blank" class="cha" href="https://www.iqiyi.com/w_19rx9ktz9t.html" >查看></a>
                                                                                    </td>

                                                                                    </tr>

                                                                                                                                                                                                                                            </tbody>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </td>
                                                </tr>
                                                                                                                                        <tr>
                                                                                                        <td class="p15 con">
                                                                                                            <table cellspacing="0" cellpadding="0" border="0">
                                                            <tbody>
                                                                <tr>
                                                                    <td class="tb1">
                                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>

                                                                                        <td valign="top" class="txt3">
                                                                                            <strong>全国移动互联网创新大赛｜二等奖</strong>
                                                                                                                                                                                            <a target="_blank" class="cha" href="https://i.51job.com/resume/ajax/image.php?type=image&amp;userid=379830840&amp;attachid=45989042&amp;key=fa702bab7eebd05eebeccfc37260a93c" >查看&gt;</a>
                                                                                                                                                                                    </td>
                                                                                </tr>
                                                                                                                                                                                                                                            </tbody>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </td>
                                                </tr>
                                                                                                                                        <tr>
                                                                                                        <td class="p15 con">
                                                                                                            <table cellspacing="0" cellpadding="0" border="0">
                                                            <tbody>
                                                                <tr>
                                                                    <td class="tb1">
                                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>

                                                                                        <td valign="top" class="txt3">
                                                                                            <strong>二维码门禁软件著作权</strong>
                                                                                                                                                                                            <a target="_blank" class="cha" href="https://i.51job.com/resume/ajax/image.php?type=image&amp;userid=379830840&amp;attachid=46171030&amp;key=fa702bab7eebd05eebeccfc37260a93c" >查看&gt;</a>
                                                                                                                                                                                    </td>
                                                                                </tr>
                                                                                                                                                                                                                                            </tbody>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </td>
                                                </tr>
                                                                                                                                        <tr>
                                                                                                        <td class="p15 con">
                                                                                                            <table cellspacing="0" cellpadding="0" border="0">
                                                            <tbody>
                                                                <tr>
                                                                    <td class="tb1">
                                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>

                                                                                        <td valign="top" class="txt3">
                                                                                            <strong>互联网+创新大赛 ｜ 三等奖</strong>
                                                                                                                                                                                            <a target="_blank" class="cha" href="https://i.51job.com/resume/ajax/image.php?type=image&userid=379830840&attachid=46170961&key=fa702bab7eebd05eebeccfc37260a93c" >查看&gt;</a>
                                                                                                                                                                                    </td>
                                                                                </tr>
                                                                                                                                                                                                                                            </tbody>
                                                                        </table>
                                                                    </td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </td>
                                                </tr>

                                                                                                                                </tbody>
                                    </table>
                                                                <!--其它-->
                                                                    <table cellspacing="0" cellpadding="0" border="0">
                                        <tbody>
                                            <tr>
                                                <td class="tit">个人评价</td>
                                            </tr>

                                                <tr>
                                                                                                        <td class="p15">
                                                                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                        <tbody>
                                                            <tr>
                                                                <td class="tb1">
                                                                    <table cellspacing="0" cellpadding="0" border="0">
                                                                        <tbody>

                                                                                                                                                            <tr>
                                                                                <td valign="top" class="txt1">&nbsp&nbsp&nbsp&nbsp具有较强的独立学习能力，在专业排名前3%。具有良好的编程习惯，善于和团队协作和交流。曾在班级担任心理委员，所以具有较强的心理素质和抗压能力，能很快的接收新的东西。在校期期间自己组织了团队参加比赛并多次获奖，并创办了自己的工作室YongTech，主要为全校师生提供电脑技术服务。从大一运营到现在，已经成为了学校的一个特色工作室。受到了学生和老师的诸多好评。爱好是登山，喜欢挑战！</td>
                                                                                </tr>
                                                                                                                                                    </tbody>
                                                                    </table>
                                                                </td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                    </td>
                                                </tr>
                                                                                        </tbody>
                                    </table>
                                                            </td>
                        </tr>
                        </tbody>
                    </table>
                            </td>
        </tr>
    </tbody>
</table>
</body>
</html>