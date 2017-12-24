;
(function ($) {
    $.fn.QuinnSlideshow = function (_config) {



		
		//var swidth=$("#slide").width();
		//alert(swidth);





        var _default = {
            speed:5000,
            animateSpeed:500,
            boxStyle: {
                "width": "350px",
                "height": "200px",
                "padding":"0px 0px 100px 0px",
                "overflow": "hidden",
                "position": "relative"
            },
            btnEnable: true,
            btnEnableClick: true,
            btnType: "number",
            btnFocusNo: 0,
            btnBottom: "105px",
            btnRight: "105px",
            btnStyle: {
                "float": "left",
                "width": "15px",
                "height": "15px",
				"border-radius": "10px",
                "background": "#fff",
                "line-height": "15px",
                "text-align": "center",
                "font-size": "10px",
                "margin-right": "3px",
                "color": "#aaa",
                "cursor": "default"
            },
            btnFocusStyle: {
                background: "#FF5C00",
                "color": "#fff"
            }
        };


        $.extend(true,_default,_config)
        this.css(_default.boxStyle);
        var me = this, meId = me.attr("id"), liCount = me.children().children().length, boxWidth = me.width();
        var slideBox, slideBoxInner, slideInterval, focusNo = _default.btnFocusNo;




        slideBox = $("<div id='" + meId + "_slideBox'>");
        slideBox.css(_default.boxStyle);
        slideBoxInner = $("<div id='" + meId + "_slideBoxInner'>");
        slideBoxInner.css({"width": "10000%"}); // �������Ա�֤ͼƬ��һ����
        me.children().css({
            "float": "left",
            "margin": 0,
            "padding": 0,
            "position": "relative",
            "list-style": "none"
        }).appendTo(slideBoxInner).children().css({
                "float": "left",
                "width": _default.boxStyle.width,
                "height": _default.boxStyle.height
            }).children().css({
                "width": _default.boxStyle.width,
                "height": _default.boxStyle.height,
                "border": 0
            });


        // ����һ��
        slideBoxInner.children().clone().appendTo(slideBoxInner);
        slideBox.append(slideBoxInner);


        me.append(slideBox);




        if (_default.btnEnable) {
            var ulBtn = $("<ul>");
            ulBtn.css({
                "position": "absolute",
                "padding": 0,
                "margin": 0,
                "bottom": _default.btnBottom,
                "right": _default.btnRight,
                "list-style": "none"
            });


            for (var i = 0; i < liCount; i++) {
                var liBtn = $("<li no=" + i + " id='" + meId + "_btn" + i + "' >" + (i + 1) + "</li>");
                liBtn.css(_default.btnStyle);
                if (_default.btnEnableClick) {
                    liBtn.click(function () {
                        clearInterval(slideInterval);
                        slideBox.clearQueue();
                        var no = parseInt($(this).attr("no"));
                        btnBlur(focusNo);
                        focusNo = no;
                        btnFocus(focusNo);
                        slideBox.animate({
                            "scrollLeft": focusNo * me.width()
                        }, _default.animateSpeed);
                        slideShow();
                    });
                }
                ulBtn.append(liBtn);
            }


            me.append(ulBtn);
            // Ĭ�Ͻ���
            $("#" + meId + "_btn" + focusNo).css(_default.btnFocusStyle);


            function btnFocus(_focusNo) {
                // �������ͼƬ������ʱ��ʵ������ʱ����ʾ���ǵ�һ�ţ���ż�0
                _focusNo = (_focusNo == liCount) ? 0 : _focusNo
                $("#" + meId + "_btn" + _focusNo).css(_default.btnFocusStyle);
            }


            function btnBlur(_focusNo) {
                _focusNo = (_focusNo == liCount) ? 0 : _focusNo
                $("#" + meId + "_btn" + _focusNo).css(_default.btnStyle);
            }


            function slideShow() {
                slideInterval = setInterval(function () {
                    btnBlur(focusNo);
                    focusNo++;
                    if (focusNo == liCount + 1) {
                        focusNo = 1;
                        // scrollLeft��Ϊ0����֤������������
                        slideBox.scrollLeft(0);
                    }
                    btnFocus(focusNo);
                    slideBox.animate({
                        "scrollLeft": focusNo * me.width()
                    }, _default.animateSpeed)
                }, _default.speed);
            }
            slideShow();
        }




    };
})(jQuery);