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
                <!--������Ϣ-->
                <table cellspacing="0" cellpadding="0" border="0" class="box1">
                    <tbody>
                        <tr>
                            <td class="hbox" align="middle">
                                <img src="https://i.51job.com/resume/ajax/image.php?type=avatar&userid=379830840&1585321623&key=fa702bab7eebd05eebeccfc37260a93c" width="85" height="104" class="head" alt="ͷ��">
                            </td>
                            <td>
                                <table cellspacing="0" cellpadding="0" border="0" class="infr">
                                    <tbody>
                                        <tr>
                                            <td colspan="2" class="name">̷����</td>
                                            <td  class="comment">����ͷ����ַ�鿴Ч�����&#8593</td>
                                        </tr>
                                        <tr>
                                            <td valign="top">
                                                <img class="vam" src="https://img01.51jobcdn.com/im/2016/resume/y1.png" width="20" height="20" />Ŀǰ�����ҹ���                                            </td>
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
                                                <img class="vam" src="https://img01.51jobcdn.com/im/2016/resume/y4.png" width="20" height="20" />��<span class="p5">|</span>23 ��<span class="p5">  | </span>�־�ס ����<span class="p5">|</span>2�깤������                                                </p>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <!--�������-->
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
                                                            <td colspan="2" class="plate2">�������</td>
                                                        </tr>
                                                        <tr>
                                                            <td valign="top" class="keys">ְλ��</td>
                                                            <td valign="top" class="txt2">java��������ʦ</td>
                                                        </tr>
                                                        <tr>
                                                            <td valign="top" class="keys">��˾��</td>
                                                            <td valign="top" class="txt2">���ڼ����������޹�˾</td>
                                                        </tr>
                                                        <tr>
                                                            <td valign="top" class="keys">��ҵ��</td>
                                                            <td valign="top" class="txt2">������/������</td>
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
                                                        <td colspan="2" class="plate2">���ѧ��/ѧλ</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top" class="keys">רҵ��</td>
                                                        <td valign="top" class="txt2">����������</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top" class="keys">ѧУ��</td>
                                                        <td valign="top" class="txt2">���������ѧ</td>
                                                    </tr>
                                                    <tr>
                                                        <td valign="top" class="keys">ѧ��/ѧλ��</td>
                                                        <td valign="top" class="txt2">����</td>
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
                                <!--������Ϣ-->
                                    <table cellspacing="0" cellpadding="0" border="0" class="box">
                        <tbody>
                            <tr>
                                <td class="plate1">������Ϣ</td>
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
                                                            <td valign="top" class="keys">����/������</td>
                                                            <td valign="top" class="txt2">����</td>
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
                                                                <td valign="top" class="keys">��ͥסַ��</td>
                                                                <td valign="top" class="txt2">�����п�����                                                                                                                                            (�ʱࣺ405412)
                                                                                                                                    </td>
                                                            </tr>
                                                        </tbody>
                                                        </table>
                                                    </td>
                                                                                                                                                    <td class="tb2" valign="top">
                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                        <tbody>
                                                            <tr>
                                                            <td valign="top" class="keys">������ò��</td>
                                                            <td valign="top" class="txt2">������Ա</td>
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

                                <!--��ְ����-->
                                    <table cellspacing="0" cellpadding="0" border="0" class="box">
                        <tbody>
                        <tr>
                            <td class="plate1">��ְ����</td>
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
                                                            <td valign="top" class="keys">���˱�ǩ��</td>
                                                            <td valign="top" class="txt1">
                                                                                                                            <span class="tag">������&nbsp;</span>
                                                                                                                            <span class="tag">java����&nbsp;</span>
                                                                                                                            <span class="tag">MySQL&nbsp;</span>
                                                                                                                            <span class="tag">��ά&nbsp;</span>
                                                                                                                            <span class="tag">�������</span>
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
                                                                <td valign="top" class="keys">�ص㣺</td>
                                                                <td valign="top" class="txt2">
                                                                                                                                        <span class="tag">����&nbsp;</span>
                                                                                                                                        <span class="tag">�ɶ�&nbsp;</span>
                                                                                                                                        <span class="tag">�人&nbsp;</span>
                                                                                                                                        <span class="tag">����</span>
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
                                                                <td valign="top" class="keys">ְ��/ְλ��</td>
                                                                <td valign="top" class="txt2">
                                                                                                                                                                                                                        <span class="tag">Java��������ʦ</span>
                                                                                                                                                <span class="tag">&nbsp;&nbsp;��ά���������Կ���</span>
                                                                                                                                    </td>
                                                            </tr>
                                                        </tbody>
                                                    </table>
                                                </td>
                                                                                                                                        <td class="tb2" valign="top">
                                                    <table cellspacing="0" cellpadding="0" border="0">
                                                    <tbody>
                                                        <tr>
                                                        <td valign="top" class="keys">��ҵ��</td>
                                                        <td valign="top" class="txt2">
                                                                                                                            <span class="tag">
                                                                    ��������                                                                </span>
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
                                                        <td valign="top" class="keys">����ʱ�䣺</td>
                                                        <td valign="top" class="txt2">��ʱ</td>
                                                        </tr>
                                                    </tbody>
                                                    </table>
                                                </td>
                                                                                                                                    <td class="tb2" valign="top">
                                                <table cellspacing="0" cellpadding="0" border="0">
                                                <tbody>
                                                    <tr>
                                                    <td valign="top" class="keys">�������ͣ�</td>
                                                    <td valign="top" class="txt2">ȫְ</td>
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
                                <!--��������-->
                                    <table cellspacing="0" cellpadding="0" border="0" class="box">
                        <tbody>
                            <tr>
                                <td class="plate1">��������</td>
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
                                                                    <strong class="txt3">Java��������ʦ</strong><span class="p5">|</span><span>ƽ̨��Ӫ��ҵ��</span>                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td class="phd tb1" colspan="2">
                                                                    <span>���ڼ����������޹�˾</span><span class="gray">&nbsp;[1��1����]</span>
                                                                </td>
                                                            </tr>
                                                                                                                            <tr>
                                                                    <td class="phd tb1 gray2" colspan="2">������/GPS��λ<span class="p5">|</span>1000������<span class="p5">|</span>��Ӫ��˾</td>
                                                                </tr>
                                                                                                                                                                                        <tr>
                                                                    <td class="tb1" colspan="2">
                                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>
                                                                                    <td valign="top" class="keys">����������</td>
                                                                                    <td valign="top" class="txt1">1�������ɴ���Ŀ����ƿ���<br>2������;ǿ���ƽ̨��������ά�Լ���������<br>3������;ǿƽ̨������ά��</td>
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
                                <!-- ��Ŀ���� -->
                                    <table cellspacing="0" cellpadding="0" border="0" class="box">
                        <tbody>
                            <tr>
                                <td class="plate1">��Ŀ����</td>
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
                                                                    <strong>���ɴ�</strong>
                                                                </td>
                                                            </tr>
                                                                                                                            <tr>
                                                                    <td class="tb1" colspan="2">
                                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>
                                                                                    <td valign="top" class="keys">������˾��</td>
                                                                                    <td valign="top" class="txt1">���ڼ����������޹�˾</td>
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
                                                                                    <td valign="top" class="keys">��Ŀ������</td>
                                                                                    <td valign="top" class="txt1">���ɴ���ҪΪ���ƽ̨���񣬽���豸��װ�������̼��ɴ�Ͱ�װ��˾�ӵ�������ϵͳ�����ʺŹ�����   ����������Լ�����չʾ��ģ�顣������Ŀ�Ƚϼ򵥣���ȫ������Ӧ����������������Springboot��ܿ������м������MQ��MySQL��</td>
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
                                                                                    <td valign="top" class="keys">����������</td>
                                                                                    <td valign="top" class="txt1">�����������Ŀ����Ҫ���ջ��Ƕ�MySQL��MyBatis���������������Ҹ����Լ�������ģ�鹦�ܲ��Ժ����ܲ��ԡ��ڲ��Թ��̲��ϵ��Ż��Լ��Ĵ���ʹ�ҵļ����õ��˺ܿ�ĳɳ���</td>
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
                                                                    <strong>;ǿ���ƽ̨</strong>
                                                                </td>
                                                            </tr>
                                                                                                                            <tr>
                                                                    <td class="tb1" colspan="2">
                                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>
                                                                                    <td valign="top" class="keys">������˾��</td>
                                                                                    <td valign="top" class="txt1">���ڼ����������޹�˾</td>
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
                                                                                    <td valign="top" class="keys">��Ŀ������</td>
                                                                                    <td valign="top" class="txt1">;ǿƽ̨��Ҫ�ǻ���GPS��λ�ĳ�������ƽ̨�������豸�����û���������̨��ͳ�Ʊ����⼸��ģ��ȣ����ƽ̨��Ҫ����Pass��Sass�����֣�Pass��Ҫ�ṩ�豸���ء����ݴ����ӿڲ�ѯ���豸��Ϣ��Ҫʹ��ActiveMQ���ж��ĺ����ͣ����ݴ洢ͨ��Redis��MongoDB��MySQL�Ƚ��д洢��ΪSass�ṩHTTP��RPC�ӿڲ�ѯ���ݡ��õ���Zookeeper��Dubbo��Sass����Ҫʹ��SpringCloud΢����ܹ���ͨ��eurekaע���뷢�ִӶ�ʵ�ַ���֮��ĵ��á���Pass֮����ӿڽ�������֮�⻹ͨ��canalʵ��MySQL���ݿ�ͬ�������澯����д��ES�С�</td>
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
                                                                                    <td valign="top" class="keys">����������</td>
                                                                                    <td valign="top" class="txt1">������Ҫ�������Sass��ҵ��������ʵ���Լ���Ŀ���ϲ������ά���������Ŀ��ѧϰ��Linux�Ĳ����Լ�Shell��Python�Ļ����÷����ܹ���дһЩ�ű�����������ά�Ͳ���ѧϰ����Ŀ�����е��м���İ�װ�Լ�ʹ�ã��˽������ǵĸ��Ե��ص㡣</td>
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
                                                                    <strong>;ǿƽ̨</strong>
                                                                </td>
                                                            </tr>
                                                                                                                            <tr>
                                                                    <td class="tb1" colspan="2">
                                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>
                                                                                    <td valign="top" class="keys">������˾��</td>
                                                                                    <td valign="top" class="txt1">���ڼ����������޹�˾</td>
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
                                                                                    <td valign="top" class="keys">��Ŀ������</td>
                                                                                    <td valign="top" class="txt1">;ǿƽ̨��Ҫ�ǻ���GPS��λ�ĳ�������ƽ̨�������豸�����û���������̨��ͳ�Ʊ����⼸��ģ�飬���п���̨��Ҫ�������豸��λ��ϢΪ�����ṩλ�÷��񣬰����켣�طš�����׷��״̬ͳ�ơ�ָ��͵ȡ�ͳ�Ʊ�����Ҫ�Ǵӳ�����������̡��豸��״̬�Լ��澯����������ά�Ƚ���ͳ�ƣ������澯ͳ�ơ��˶�ͳ�ơ��豸ͳ�ơ�</td>
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
                                                                                    <td valign="top" class="keys">����������</td>
                                                                                    <td valign="top" class="txt1">������Ҫ���ڵ�ʦ��ָ����ѧϰ��Ŀ�����������Լ���˾��ҵ�����󣬶���дһЩ��Ԫ�����Լ����ݿ����ơ�</td>
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
                                <!--��������-->
                                    <table class="box">
                        <tbody>
                            <tr>
                                <td class="plate1">��������</td>
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
                                                                    <strong>���������ѧ</strong>                                                                </td>
                                                            </tr>
                                                            <tr>
                                                                <td class="tb1" colspan="2">����<span class="p5">|</span>����������                                                                </td>
                                                            </tr>
                                                                                                                            <tr>
                                                                    <td class="tb1" colspan="2">
                                                                        <table cellspacing="0" cellpadding="0" border="0">
                                                                            <tbody>
                                                                                <tr>
                                                                                    <td valign="top" class="keys">���޿γ̣�</td>
                                                                                    <td valign="top" class="txt1">C���ԡ�Java��Java Web��HTML/CSS/JavaScript��MySQL�����ݽṹ����������硢������̵��ۡ�Python����Ƭ���������������������硢Ƕ��ʽ��UC/OS-II��</td>
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
                                <!--��У���-->
                                    <table cellspacing="0" cellpadding="0" border="0" class="box">
                        <tbody>
                            <tr>
                                <td class="plate1">��У���</td>
                            </tr>
                            <tr>
                                <td class="tbb">
                                <!--У������-->
                                                                    <table cellspacing="0" cellpadding="0" border="0">
                                        <tbody>
                                            <tr>
                                                <td class="tit">У������</td>
                                            </tr>
                                                                                                                                        <tr>
                                                                                                        <td class="tb3">
                                                                                                            <table cellspacing="0" cellpadding="0" border="0">
                                                            <tbody>
                                                                <tr>
                                                                    <td valign="top" class="time">2018/9</td>
                                                                    <td valign="top" class="rtbox">
                                                                        <strong class="txt3">������־��ѧ��</strong>
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
                                                                        <strong class="txt3">�������Ȩ����</strong>
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
                                                                        <strong class="txt3">ȫ���ƶ����������´���</strong>
                                                                                                                                                    <span>�����Ƚ���</span>
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
                                                                        <strong class="txt3">I CAN���ʴ��´�ҵ����</strong>
                                                                                                                                                    <span>�����Ƚ���</span>
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
                                                                        <strong class="txt3">ȫ����ѧ����������ƾ�����TI)��</strong>
                                                                                                                                                    <span>��һ�Ƚ���</span>
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
                                                                        <strong class="txt3">ȫ����ѧ�������������ƴ���</strong>
                                                                                                                                                    <span>�����Ƚ���</span>
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
                                                                        <strong class="txt3">���Ҽ���ѧ�����´�ҵ����</strong>
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
                                <!--�����س�-->
                                    <table cellspacing="0" cellpadding="0" border="0" class="box">
                        <tbody>
                            <tr>
                                <td class="plate1">
                                �����س�                                    <span class="f12">������IT���ܡ�֤�飩</span>
                                </td>
                            </tr>
                            <tr>
                                <td class="tbb">
                                    <!--����/����-->
                                                                            <table cellspacing="0" cellpadding="0" border="0">
                                            <tbody>
                                                <tr>
                                                    <td class="tit">����/����</td>
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
                                                                                    <strong class="txt3">Webǰ��</strong>
                                                                                </td>
                                                                                <td valign="top">
                                                                                    <span class="skbg">
                                                                                    <span class="skco">����</span>
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
                                                                                    <span class="skco">����</span>
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
                                                                                    <span class="skco">����</span>
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
                                                                                    <span class="skco">����</span>
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
                                                                                    <span class="skco">����</span>
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
                                                                                    <span class="skco">����</span>
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
                                                                                    <span class="skco">����</span>
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
                                                                                    <span class="skco">����</span>
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
                                                                        <!--֤��-->
                                                                            <table cellspacing="0" cellpadding="0" border="0">
                                            <tbody>
                                                <tr>
                                                    <td class="tit">֤��ɨ���</td>
                        <tr>
                            <td class="tbb">
                                <!--��������-->
                                                                <!--����-->
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
                                                                                            <strong>ȫ����ѧ����������ƾ�����һ�Ƚ�</strong>
                                                                                                                                                                                            <a target="_blank" class="cha" href="https://i.51job.com/resume/ajax/image.php?type=image&userid=379830840&attachid=45989031&key=fa702bab7eebd05eebeccfc37260a93c" >�鿴&gt;</a>
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
                                                                                            <strong>�ɸ�APP�������Ȩ</strong>
                                                                                                                                                                                            <a target="_blank" class="cha" href="https://i.51job.com/resume/ajax/image.php?type=image&amp;userid=379830840&amp;attachid=46171009&amp;key=fa702bab7eebd05eebeccfc37260a93c" >�鿴&gt;</a>
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
                                                                                            <strong>iCan���ʴ��´�ҵ���������Ƚ�</strong>
                                                                                                                                                                                            <a target="_blank" class="cha" href="https://i.51job.com/resume/ajax/image.php?type=image&amp;userid=379830840&amp;attachid=46171004&amp;key=fa702bab7eebd05eebeccfc37260a93c" >�鿴&gt;</a>
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
                                                                                          <strong>�ɸ�APP��ʾ��Ƶ</strong>
                                                                                        <a target="_blank" class="cha" href="https://www.iqiyi.com/w_19rx9ktz9t.html" >�鿴></a>
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
                                                                                            <strong>ȫ���ƶ����������´��������Ƚ�</strong>
                                                                                                                                                                                            <a target="_blank" class="cha" href="https://i.51job.com/resume/ajax/image.php?type=image&amp;userid=379830840&amp;attachid=45989042&amp;key=fa702bab7eebd05eebeccfc37260a93c" >�鿴&gt;</a>
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
                                                                                            <strong>��ά���Ž��������Ȩ</strong>
                                                                                                                                                                                            <a target="_blank" class="cha" href="https://i.51job.com/resume/ajax/image.php?type=image&amp;userid=379830840&amp;attachid=46171030&amp;key=fa702bab7eebd05eebeccfc37260a93c" >�鿴&gt;</a>
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
                                                                                            <strong>������+���´��� �� ���Ƚ�</strong>
                                                                                                                                                                                            <a target="_blank" class="cha" href="https://i.51job.com/resume/ajax/image.php?type=image&userid=379830840&attachid=46170961&key=fa702bab7eebd05eebeccfc37260a93c" >�鿴&gt;</a>
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
                                                                <!--����-->
                                                                    <table cellspacing="0" cellpadding="0" border="0">
                                        <tbody>
                                            <tr>
                                                <td class="tit">��������</td>
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
                                                                                <td valign="top" class="txt1">&nbsp&nbsp&nbsp&nbsp���н�ǿ�Ķ���ѧϰ��������רҵ����ǰ3%���������õı��ϰ�ߣ����ں��Ŷ�Э���ͽ��������ڰ༶��������ίԱ�����Ծ��н�ǿ���������ʺͿ�ѹ�������ܺܿ�Ľ����µĶ�������У���ڼ��Լ���֯���ŶӲμӱ�������λ񽱣����������Լ��Ĺ�����YongTech����ҪΪȫУʦ���ṩ���Լ������񡣴Ӵ�һ��Ӫ�����ڣ��Ѿ���Ϊ��ѧУ��һ����ɫ�����ҡ��ܵ���ѧ������ʦ���������������ǵ�ɽ��ϲ����ս��</td>
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