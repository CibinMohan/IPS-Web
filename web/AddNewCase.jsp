<%@page import="com.ips.bean.LoginBean"%>
<%@page import="com.ips.util.AppConstants"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>IPS Case</title>
        <meta charset="utf-8">
        <link rel="stylesheet" href="css/reset.css" type="text/css" media="all">
        <link rel="stylesheet" href="css/layout.css" type="text/css" media="all">
        <link rel="stylesheet" href="css/style.css" type="text/css" media="all">
        <script type="text/javascript" src="js/jquery-1.4.2.js" ></script>
        <script type="text/javascript" src="js/cufon-yui.js"></script>
        <script type="text/javascript" src="js/cufon-replace.js"></script>
        <script type="text/javascript" src="js/Myriad_Pro_300.font.js"></script>
        <script type="text/javascript" src="js/Myriad_Pro_400.font.js"></script>
        <!--[if lt IE 9]>
        <script type="text/javascript" src="js/ie6_script_other.js"></script>
        <script type="text/javascript" src="js/html5.js"></script>
        <![endif]-->
        <style type="text/css">
            <!--
            #apDiv1 {
                position:absolute;
                width:480px;
                height:462px;
                z-index:3;
                left: 332px;
                top: 108px;
            }
            -->
        </style>
    </head>
    <body id="page5">
        <!-- START PAGE SOURCE -->

        <%
                    String status = request.getParameter("status");
                    if (status != null && !status.equals("") && status.equals("true")) {
        %>
        <h2><center>Add Case Successfully..</center></h2>
        <%} else {%>
        <h2><center>Add Case failed Retry..</center></h2>
        <%}%>

        <div class="body1"></div>
        <div class="body2">
            <div class="main">
                <header>
                    <div class="wrapper">
                        <nav>
                            <ul id="menu">
                                <li><a href="Police.jsp">Home</a></li>
                                <li><a href="services.jsp">Services</a></li>
                                <li id="menu_active" class="bg_none">
                                    <a href="contacts.jsp">Contacts</a></li>
                                <li><a href="index.jsp">Logout</a></li>
                            </ul>
                        </nav>
                        <h1>&nbsp;</h1>
                    </div>
                    <div class="wrapper">
                        <article class="col1 pad_left2">
                            <div class="text1">IPS<span>of Scientific Thinking</span></div>
                            <p>Security police protect their agency's facilities, properties,   personnel, users, visitors and operations from harm and may enforce   certain laws and administrative regulations. . <a href="#" class="link1">Read More</a> </p>
                        </article>
                    </div>
                </header>
            </div>
        </div>
        <div class="body3">
            <div class="main">
                <section id="content_top">
                    <article class="pad_left2 col3">
                        <h2>&nbsp;</h2>
                    </article>
                    <article class="pad_left1 col2">
                        <h2>Miscellaneous Info:</h2>
                        <p class="marg_top">Security police protect their agency's facilities, properties,   personnel, users, visitors and operations from harm and may enforce   certain laws and administrative regulations. Most security police have   at least some arrest authority. The law enforcement powers of security   police vary widely, in some cases limited to those of private persons   yet in others amounting to full police powers equivalent to state,   provincial, or local law enforcement.</p>
                    </article>
                </section>
            </div>
        </div>
        <div class="main">
            <section id="content">
                <article class="pad_left2">
                    <h2 class="title"> New Case Registeration</h2>
                    <ul id="form_fields">
                        <form name="form1" id="form1" method="post" action="CaseRegistration?username=1">
                            <li><strong>Suspect Name :</strong></li>
                            <li>
                                <input type="text" name="name" id="name" />
                            </li>
                            <li><strong>Suspect Adhaar NO :</strong></li>
                            <li><input type="text" name="adhaar" id="adhaar" /> </li>
                            <li><strong> Phone :</strong></li>
                            <li><input type="text" name="phone" id="phone" /> </li>
                            <li><strong> email :</strong></li>
                            <li><input type="text" name="email" id="email" /> </li>
                            <li><strong> Vhicle No :</strong></li>
                            <li>   <input type="text" name="vhicle" id="vhicle" /></li>

                            <div id="apDiv1">

                                <li><strong>Victim Adhaar NO :</strong></li>
                                <li><input type="text" name="victimAdhaar" id="victimAdhaar" /> </li>
                                <li><strong> Location : </strong></li>
                                <li><input type="text" name="location" id="location" /></li>
                                <li style="margin-top:15px;"><strong> Address:</strong></li>
                                <li><textarea name="address" id="address" rows="3" cols="32" style=" background-color:#CCCCCC;"> </textarea>
                                <li ><input type="submit" name="submit"  value="Submit"  style="margin-right:0px; margin-top:0px; background-color:#666666"/></li>
                                <li ></li>
                                <li ></li>
                            </div>
                        </form>
                    </ul>
                    </div>
                </article>
            </section>
        </div>
        <div class="body4">
            <div class="main">
                <div id="footer_menu">
                    <nav>
                        <ul>
                            <li><a href="#">Home</a></li>
                            <li><a href="#">Researches</a></li>
                            <li><a href="#">Services</a></li>
                            <li><a href="#">Events</a></li>
                            <li class="bg_none"><a href="#">Contacts</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    <footer></footer>
    <script type="text/javascript"> Cufon.now(); </script>
    <!-- END PAGE SOURCE -->
    <div align=center></div>

</body>
</html>