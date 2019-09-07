// 图片轮播
// 封装一个代替getElementById的方法
function byId(id){
    return typeof(id) === "string" ? document.getElementById(id) : id;
}
// 全局变量
var index = 0,  // 轮播div图片
    timer = null, // 重复执行某段代码的触发器
    pics = byId("banner").getElementsByTagName("div"), // 指向指定区域的div数量
    dots = byId("dots").getElementsByTagName("span"), // 圆点
    prev = byId("prev"); // 上一张和下一张
    next = byId("next");
    len = pics.length; // 动态根据图片数量进行自动调整

function slideImg(){
    var main = byId("main");
    // 鼠标划在滑块中时,清除所有触发器，图片停止轮播
    main.onmouseover = function(){
        if (timer) clearInterval(timer);
    }
    // 鼠标划在滑块外时，onmouseout事件
    main.onmouseout = function(){
        timer = setInterval(function (){
            index ++;
            if (index >= len){
                index = 0;
            }
            changeImg();
        }, 3000);
    }
    main.onmouseout(); // onmouseout方法，进入网页后自动轮播图片
    
    // 遍历所有的点击事件，且绑定点击事件，点击圆点切换图片
    for (var d = 0; d < len; d ++){
        // 为所有的span属性添加一个id值
        dots[d].id = d;
        dots[d].onclick = function(){
            index = this.id;
            changeImg();
        }
    }

    // 上一张和下一张
    prev.onclick = function(){
        index --;
        if (index < 0){
            index = len - 1;
            console.log(index);
        }
        changeImg();
    }
    next.onclick = function(){
        index ++;
        if (index >= len) index = 0;
        changeImg();
    }
}

// 隐藏和显示图片
function changeImg(){
    // 将所有图片隐藏，并清除所有的实体圆点
    for (var i = 0; i < len; i ++){
        pics[i].style.display = "none";
        dots[i].className = "";
    }
    // 将index的图片和右下角实体圆点显示
    pics[index].style.display = "block";
    dots[index].className = "active";
}

slideImg();