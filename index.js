
$(function(){
	initImage();
	$.ajax({
		url:"InitBlock",
		type:"post",
		success:function(data){
			
		}
	});
	
});
var ch={
	"R":"Ju",
	"N":"Ma",
	"B":"Xa",
	"A":"Si",
	"K":"Ja",
	"C":"Po",
	"P":"Bi"
};//棋子对应


 /*图像初始化*/
function initImage(){
	var span1=$(".chessboard").find(".chess").find("div").eq(0).find("span");
    span1.eq(0).css({"background-image": "url('chess/POLISH/BR.GIF')"});
    span1.eq(1).css({"background-image": "url('chess/POLISH/BN.GIF')"});
    span1.eq(2).css({"background-image": "url('chess/POLISH/BB.GIF')"});
    span1.eq(3).css({"background-image": "url('chess/POLISH/BA.GIF')"});
    span1.eq(4).css({"background-image": "url('chess/POLISH/BK.GIF')"});
    span1.eq(5).css({"background-image": "url('chess/POLISH/BA.GIF')"});
    span1.eq(6).css({"background-image": "url('chess/POLISH/BB.GIF')"});
    span1.eq(7).css({"background-image": "url('chess/POLISH/BN.GIF')"});
    span1.eq(8).css({"background-image": "url('chess/POLISH/BR.GIF')"});
    var span3=$(".chessboard").find(".chess").find("div").eq(2).find("span");
    span3.eq(1).css({"background-image": "url('chess/POLISH/BC.GIF')"});
    span3.eq(7).css({"background-image": "url('chess/POLISH/BC.GIF')"});
    var span4=$(".chessboard").find(".chess").find("div").eq(3).find("span");
    span4.eq(0).css({"background-image": "url('chess/POLISH/BP.GIF')"});
    span4.eq(2).css({"background-image": "url('chess/POLISH/BP.GIF')"});
    span4.eq(4).css({"background-image": "url('chess/POLISH/BP.GIF')"});
    span4.eq(6).css({"background-image": "url('chess/POLISH/BP.GIF')"});
    span4.eq(8).css({"background-image": "url('chess/POLISH/BP.GIF')"});
    
     var span8=$(".chessboard").find(".chess").find("div").eq(7).find("span");
    span8.eq(1).css({"background-image": "url('chess/POLISH/RC.GIF')"});
    span8.eq(7).css({"background-image": "url('chess/POLISH/RC.GIF')"});
    var span7=$(".chessboard").find(".chess").find("div").eq(6).find("span");
    span7.eq(0).css({"background-image": "url('chess/POLISH/RP.GIF')"});
    span7.eq(2).css({"background-image": "url('chess/POLISH/RP.GIF')"});
    span7.eq(4).css({"background-image": "url('chess/POLISH/RP.GIF')"});
    span7.eq(6).css({"background-image": "url('chess/POLISH/RP.GIF')"});
    span7.eq(8).css({"background-image": "url('chess/POLISH/RP.GIF')"});
   
   	var span9=$(".chessboard").find(".chess").find("div").eq(9).find("span");
    span9.eq(0).css({"background-image": "url('chess/POLISH/RR.GIF')"});
    span9.eq(1).css({"background-image": "url('chess/POLISH/RN.GIF')"});
    span9.eq(2).css({"background-image": "url('chess/POLISH/RB.GIF')"});
    span9.eq(3).css({"background-image": "url('chess/POLISH/RA.GIF')"});
    span9.eq(4).css({"background-image": "url('chess/POLISH/RK.GIF')"});
    span9.eq(5).css({"background-image": "url('chess/POLISH/RA.GIF')"});
    span9.eq(6).css({"background-image": "url('chess/POLISH/RB.GIF')"});
    span9.eq(7).css({"background-image": "url('chess/POLISH/RN.GIF')"});
    span9.eq(8).css({"background-image": "url('chess/POLISH/RR.GIF')"});
    for(var i=0;i<=9;i++){
    	var div=$(".chess").find("div").eq(i);
    	for(var j=0;j<=8;j++){
    		div.find("span").eq(j).attr("onclick","deal(this,"+i+","+j+")");
    	}
    }
	
}
var chooseI=-1,chooseJ=-1;//初始化开始选中棋子
var choosedFlag=false;//选中棋子标志
function deal(t,i,j){
//	if(i==chooseI||j==chooseJ){
//		return;
//	}
		if($(t).css("background-image")!="none"&&$(t).css("background-image")!=null){//选中的位有棋子
		//先验证一下之前是否选中了一个棋子，再执行if
		if(chooseI!=-1&&chooseJ!=-1){//要移动的棋子已经被选中
			//后端验证能否吃子
//			alert(ch[$(t).css("background-image").split("/")[6].split(".")[0].charAt(1)+""])
			$.ajax({
				url:"JudgeMove",
				type:"post",
				data:{
					"start_x":chooseI,
					"start_y":chooseJ,
					"end_x":i,
					"end_y":j,
					"flag":ch[$(".chess").find("div").eq(chooseI).find("span").eq(chooseJ).css("background-image").split("/")[6].split(".")[0].charAt(1)+""]
				},
			//	asyn:true,
				dataType:"json",
				success:function(data){
					if(data.result=="success"){//能移动，同一方的棋子后台验证肯定是false
						var url=$(".chess").find("div").eq(chooseI).find("span").eq(chooseJ).css("background-image").split("/")[6].split(".")[0].replace("S","");
						url="chess/POLISH/"+url+".GIF";
						$(".chess").find("div").eq(chooseI).find("span").eq(chooseJ).css("background-image","none");//清除原来位置图像
						$(".chess").find("div").eq(i).find("span").eq(j).css({//移动到的位置更新图像
							"background-image":"url('"+url+"')"
						});
						
					}else{
						var url=$(".chess").find("div").eq(chooseI).find("span").eq(chooseJ).css("background-image").split("/")[6].split(".")[0].replace("S","");
							url="chess/POLISH/"+url+".GIF";
							$(".chess").find("div").eq(chooseI).find("span").eq(chooseJ).css({//恢复之前没选中图像
								"background-image":"url('"+url+"')"
							});
						
					}
					chooseI=-1;
					chooseJ=-1;
				}
			});
			
			
			choosedFlag=false;
		}else{//第一次选中棋子
			//将当前图片标记为选中状态
			var url= $(t).css("background-image").split("/")[6].split(".")[0];
			url="chess/POLISH/"+url+"S.GIF";
			$(t).css({
				"background-image":"url('"+url+"')"
			});	
			chooseI=i;
			chooseJ=j;
			choosedFlag=true;//选中标记
		}}else{//选中的不是棋子
			if(chooseI!=-1&&chooseJ!=-1){//要移动的棋子已经被选中
				//后端验证能否移动
				$.ajax({
				url:"JudgeMove",
				type:"post",
				data:{
					"start_x":chooseI,
					"start_y":chooseJ,
					"end_x":i,
					"end_y":j,
					"flag":ch[$(".chess").find("div").eq(chooseI).find("span").eq(chooseJ).css("background-image").split("/")[6].split(".")[0].charAt(1)+""]
				},
			//	asyn:true,
				dataType:"json",
				success:function(data){
					if(data.result=="success"){//能移动
						var url=$(".chess").find("div").eq(chooseI).find("span").eq(chooseJ).css("background-image").split("/")[6].split(".")[0].replace("S","");
						url="chess/POLISH/"+url+".GIF";
						$(".chess").find("div").eq(chooseI).find("span").eq(chooseJ).css("background-image","none");//清除原来位置图像
						$(".chess").find("div").eq(i).find("span").eq(j).css({//移动到的位置更新图像
							"background-image":"url('"+url+"')"
						});
						
					}else{
						var url=$(".chess").find("div").eq(chooseI).find("span").eq(chooseJ).css("background-image").split("/")[6].split(".")[0].replace("S","");
						url="chess/POLISH/"+url+".GIF";
						$(".chess").find("div").eq(chooseI).find("span").eq(chooseJ).css({//恢复之前没选中图像
							"background-image":"url('"+url+"')"
						});
//						alert("该步不能走！");
						
					}
					chooseI=-1;
					chooseJ=-1;
				}
				});
			}else{
				alert("选择无效！");
			}
		}
		
}


