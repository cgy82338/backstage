
accessid = ''
accesskey = ''
host = ''
policyBase64 = ''
signature = ''
callbackbody = ''
filename = ''
key = ''
expire = 0
g_object_name = ''
g_object_name_type = ''
now = timestamp = Date.parse(new Date()) / 1000; 
callback_var='';
function send_request()
{
    var xmlhttp = null;
    if (window.XMLHttpRequest)
    {
        xmlhttp=new XMLHttpRequest();
    }
    else if (window.ActiveXObject)
    {
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
  
    if (xmlhttp!=null)
    {
        // serverUrl是 用户获取 '签名和Policy' 等信息的应用服务器的URL，请将下面的IP和Port配置为您自己的真实信息。
        serverUrl = 'http://39.105.0.196/ossDirect'
		
        xmlhttp.open( "GET", serverUrl, false );
        xmlhttp.send( null );
        return xmlhttp.responseText
    }
    else
    {
        alert("您的浏览器不支持 XMLHTTP.");
    }
};

//选取按钮
function check_object_radio() {
    var tt = document.getElementsByName('myradio');
    for (var i = 0; i < tt.length ; i++ )
    {
        if(tt[i].checked)
        {
            g_object_name_type = tt[i].value;
            break;
        }
    }
}

//获取签名
function get_signature()
{
    // 可以判断当前expire是否超过了当前时间， 如果超过了当前时间， 就重新取一下，3s 作为缓冲。
    now = timestamp = Date.parse(new Date()) / 1000; 
    if (expire < now + 3)
    {
        body = send_request()
        var obj = eval ("(" + body + ")");
        host = obj['host']
        policyBase64 = obj['policy']
        accessid = obj['accessid']
        signature = obj['signature']
        expire = parseInt(obj['expire'])
        callbackbody = obj['callback'] 
        key = obj['dir']
        return true;
    }
    return false;
};

//获取文件后缀  
function get_suffix(filename) {
    pos = filename.lastIndexOf('.')
    suffix = ''
    if (pos != -1) {
        suffix = filename.substring(pos)
    }
    return suffix;
}

//获取文件名
function calculate_object_name(filename)
{
    suffix = get_suffix(filename)
    g_object_name +=  uuid() + suffix
}

function set_upload_param(up, filename, ret)
{
    if (ret == false)
    {
        //获取签名信息
        ret = get_signature()
    }
    //g_object_name = key;//文件上传目录
    var myDate = new Date();
	var year = myDate.getFullYear();    //获取完整的年份
	var month = myDate.getMonth()+1;       //获取当前月份
	var strDate = myDate.getDate();        //获取当前日
	
	if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
//	alert("获取当前月份"+month);
//	alert("获取当前日"+strDate);
	var suffix2 = get_suffix(filename).toLowerCase()
	
	if( suffix2 == '.png' || suffix2 == '.jpg' || suffix2 == '.jpeg' || suffix2 == '.bmp' || suffix2 == '.gif' ){
//		alert("image");
		g_object_name = 'sharedfiles/'+'image/'+year+"/"+month+"/"+strDate+"/";//文件上传目录
	} else if (suffix2 == '.mp4' || suffix2 == '.3gp' || suffix2 == '.mov' || suffix2 == '.m4v' || suffix2 == '.rmvb' || suffix2 == '.wmv' || suffix2 == '.flv' || suffix2 == '.avi' ) {
//		alert("video");
		g_object_name = 'sharedfiles/'+'video/'+year+"/"+month+"/"+strDate+"/";//文件上传目录
	} else if (suffix2 == '.txt' || suffix2 == '.doc' || suffix2 == '.pdf' || suffix2 == '.docx' || suffix2 == '.ppt' || suffix2 == '.pptx' || suffix2 == '.xls' || suffix2 == '.xlsx') {
//		alert("file");
		g_object_name = 'sharedfiles/'+'file/'+year+"/"+month+"/"+strDate+"/";//文件上传目录
	} else if (suffix2 == '.mp3' || suffix2 == '.wav' || suffix2 == '.aac' ) {
//		alert("audio");
		g_object_name = 'sharedfiles/'+'audio/'+year+"/"+month+"/"+strDate+"/";//文件上传目录
	} else {
//		alert("other");
		g_object_name = 'sharedfiles/'+'other/'+year+"/"+month+"/"+strDate+"/";//文件上传目录
	}
	
    //当有地址时
    if (filename != '') { 
    	suffix = get_suffix(filename)//获取文件后缀
        calculate_object_name(filename)
    }
    new_multipart_params = {
        'key' : g_object_name,
        'policy': policyBase64,
        'OSSAccessKeyId': accessid,
        'success_action_status' : '200', //让服务端返回200,不然，默认会返回204
		'callback' : callbackbody,
        'signature': signature,
        'callback-var':callback_var
    };

    up.setOption({
        'url': host,
        'multipart_params': new_multipart_params
    });

    up.start();
}

//生成UUID
function uuid() {
    var s = [];
    var hexDigits = "0123456789abcdefghjklmnpqrstuvwxyz";
    for (var i = 0; i < 36; i++) {
        s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
    }
    s[14] = "4"; // bits 12-15 of the time_hi_and_version field to 0010
    s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1); // bits 6-7 of the clock_seq_hi_and_reserved to 01
    //s[8] = s[13] = s[18] = s[23] = "-";//禁止中间添加“-”
    s[8] = s[13] = s[18] = s[23] = "";
    var uuid = s.join("");
    return uuid;
}

var uploader = new plupload.Uploader({
	runtimes : 'html5,flash,silverlight,html4',
	browse_button : 'selectfiles',    //点击选择文件
    multi_selection: false,
	container: document.getElementById('container'),
	flash_swf_url : 'lib/plupload-2.1.2/js/Moxie.swf',
	silverlight_xap_url : 'lib/plupload-2.1.2/js/Moxie.xap',
    url : 'http://oss.aliyuncs.com',
//    resize: {
//        width: 1500,
//        crop: false,
//        preserve_headers: true
//    },
    filters: {
//        mime_types : [ //只允许上传图片和zip文件
//        { title : "Image files", extensions : "jpg,gif,png,bmp" }, 
//        { title : "Zip files", extensions : "zip,rar" },
//        { title : "video files", extensions : "mp4" }
//        ],
        max_file_size : '5120mb', //最大只能上传5120mb的文件
        prevent_duplicates : true //不允许选取重复文件
    },

	init: {
		PostInit: function() {
			document.getElementById('ossfile').innerHTML = '';
			document.getElementById('postfiles').onclick = function() { //点击上传
            set_upload_param(uploader, '', false);//初始化 请求 sign
            return false;
			};
		},
  
		FilesAdded: function(up, files) {// 添加文件之后
			if (up.files.length > 1) {//判断队列中的文件数量，当大于2时删除旧的
				up.splice(0,1);
            }
			plupload.each(files, function(file) {
				document.getElementById('ossfile').innerHTML = '<div id="' + file.id + '">' + file.name + ' (' + plupload.formatSize(file.size) + ')<b></b>'
				+'<div class="progress"><div class="progress-bar" style="width: 0%"></div></div>'
				+'</div>';
			});
		},

		BeforeUpload: function(up, file) {//上传之前
            check_object_radio();
            set_upload_param(up, file.name, true);
        },

		UploadProgress: function(up, file) {//监听上传文件进度
			var d = document.getElementById(file.id);
			d.getElementsByTagName('b')[0].innerHTML = '<span>' + file.percent + "%</span>";
            var prog = d.getElementsByTagName('div')[0];
			var progBar = prog.getElementsByTagName('div')[0]
			progBar.style.width= 2*file.percent+'px';
			progBar.setAttribute('aria-valuenow', file.percent);
		},

		FileUploaded: function(up, file, info) {//上传文件成功之后
			
			try{
                var obj =  JSON.parse(info.response.toString()); //由JSON字符串转换为JSON对象
                var result_status= obj.Status;//解析上传之后服务器返回的状态
                if (info.status == 200 && result_status==200 )
                {
                	var url = host+"/"+g_object_name;//文件上传目录
                	document.getElementById('file_url').value = url;
                	var file_type =/\.[^\.]+/.exec(g_object_name);//获取文件类型，包含"."
                	document.getElementById('file_type').value = file_type;
                	//设置文件大小
                	if (file.size < 1024) {
//    					alert(file.size+"b");
    					document.getElementById('file_size').value = file.size+"B";
    				} else if (file.size/1024 < 1024) {
    					var file_size = file.size/1024;
    	            	var num = file_size.toFixed(2); // 四舍五入精确到小数点后两位
//    					alert(num+"Kb");
    					document.getElementById('file_size').value = num+"KB";
    				} else if (file.size/1024/1024 < 1024) {
    					var file_size = file.size/1024/1024;
    	            	var num = file_size.toFixed(2); // 四舍五入精确到小数点后两位
//    					alert(num+"Mb");
    					document.getElementById('file_size').value = num+"MB";
    				} else {
    					var file_size = file.size/1024/1024/1024;
    	            	var num = file_size.toFixed(2); // 四舍五入精确到小数点后两位
//    					alert(num+"Gb");
    					document.getElementById('file_size').value = num+"GB";
    				}
                }
                else//上传失败
                {
                	alert("上传失败，请重试！");
                }
            }catch (e) {//断网，异常处理
            	alert("服务器异常，请稍后重试！");
            }
			
		},

		Error: function(up, err) {
            if (err.code == -600) {
            	alert("文件大小超过限制");
//                document.getElementById('console').appendChild(document.createTextNode("\n选择的文件太大了,可以根据应用情况，在upload.js 设置一下上传的最大大小"));
            }
            else if (err.code == -601) {
            	alert("不支持该文件类型");
//            	document.getElementById('console').appendChild(document.createTextNode("\n选择的文件后缀不对,可以根据应用情况，在upload.js进行设置可允许的上传文件类型"));
            }
            else if (err.code == -602) {
                alert("不可重复选择同一文件");
//            	document.getElementById('console').appendChild(document.createTextNode("\n这个文件已经上传过一遍了"));
            }
            else 
            {
            	alert("Error xml:" + err.response);
//                document.getElementById('console').appendChild(document.createTextNode("\nError xml:" + err.response));
            }
		}
	}
});

uploader.init();
