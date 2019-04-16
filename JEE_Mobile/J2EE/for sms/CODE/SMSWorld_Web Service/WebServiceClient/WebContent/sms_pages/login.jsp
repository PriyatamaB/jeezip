<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>SMS WORLD</title>
<script language="javascript" type="text/javascript">
function newuser()
{
	window.document.loginfrm.action="../user/newUser.action";
	document.loginfrm.submit;
}
function userlogin()
{
	if(document.loginfrm.login.value="")
		{
		  alert("Please Enter UserName and password");
		  return false;
		}
	else
		{
			document.loginfrm.action="../test/validate.action";
			document.loginfrm.submit;
		}
}
</script>
<style type="text/css">
		@import url("../css_pages/login_style.css");
	</style>
</head>
 
<body>
<form name="loginfrm" method="post">
<div id="sms">
  <div id="header">
   	<div class="tlinks">
    	<div class="mm">
        	<h2 class="flt">Welcome To Free SMS World.......</h2>            
        </div>
     </div>
     <div class="logo">
        <div class="mm">
        	<a href="http://www.way2sms.com"><img src="../Images/way2sms-logo.png" height="80"></a>
        	<img src="../Images/cartoon.jpg" width="580px" height="80px">        	       
        </div>        
     </div>
   </div>
    
    <div id="container">
    	<div id="login">
       	  <div class="reg flt">
            		<b>New user ?</b>
                    <strong>Don't Have an account.</strong>
                    <span>Don't worry!</span>
                    <hr>
            <input type="submit" name="register" value="Register Here"  style='cursor:pointer;' onclick="return newuser()">
          </div>
          <div class="login flt">
            	<em>Already A Member ?</em>
                	<h3><font face="Cooper Black" color="black">Login to SMS WORLD</font> </h3>
                    <div class="log">
                    	<p>
                        	<label>Mobile:</label>
                  			<input  id="mbno" name="mbno" type="text"/>
                  			
                          	<span>Ex: 9860985337</span>
                        </p>
                        <p>
                        	<label>Password:</label>
                          	<input id="password" name="password" type="password" />
                        </p>
                      <div class="forgo frt">
                       	  <p>
                       	  <a href="../sms_pages/forgotPass.jsp">Forgot your password?</a>
                       	  </p>                            
                        </div>
                      <div class="but flt">
                          <input type="submit" name="login" id="button" value="Login" onclick="userlogin()">
                        </div>
                  </div>
                </div>
            <div class="tt frt">
            	<div style='width:300px; height:250px;'>
					<img src="../Images/bulksms.jpg" width="300px" height="250px">
				</div>
            </div>
            <div class="clrb"></div>
        </div>
                    <div class="contDiv">
            	<div class="fbotlink">
    				<a href="about_us.html" target="_blank">About Us</a>  |  
    				<a href="help.html" target="_blank">Help Center</a>        	
    			</div>
			</div>
		</div>
  </div>    
</form>
</body>
</html>