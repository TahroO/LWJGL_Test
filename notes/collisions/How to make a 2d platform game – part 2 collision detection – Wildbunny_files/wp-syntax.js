var _____WB$wombat$assign$function_____ = function(name) {return (self._wb_wombat && self._wb_wombat.local_init && self._wb_wombat.local_init(name)) || self[name]; };
if (!self.__WB_pmw) { self.__WB_pmw = function(obj) { this.__WB_source = obj; return this; } }
{
  let window = _____WB$wombat$assign$function_____("window");
  let self = _____WB$wombat$assign$function_____("self");
  let document = _____WB$wombat$assign$function_____("document");
  let location = _____WB$wombat$assign$function_____("location");
  let top = _____WB$wombat$assign$function_____("top");
  let parent = _____WB$wombat$assign$function_____("parent");
  let frames = _____WB$wombat$assign$function_____("frames");
  let opener = _____WB$wombat$assign$function_____("opener");

jQuery(document).ready(function($)
{
	$('.wp_syntax').bind(
	{
		mouseover: function()
		{
			var w = $(this).find('table').outerWidth();
			var hw = $(document).width() - $(this).offset().left - 20;

			/*
			 * Test code.
			 */
			/*var left, top;
			left = $(this).offset().left;
			top = $(this).offset().top;

			$(this)
				.appendTo('body')
				.css({
				'position': 'absolute',
				'left': left + 'px',
				'top': top + 'px'
			});
			*/

			if(w > $(this).outerWidth()) {
				// $(this).css({'position':'relative', 'z-index':'9999', 'box-shadow':'5px 5px 5px #888', 'width':(w > hw ? hw : w)+'px'});
				$(this).css({'position':'relative', 'z-index':'9999', 'width':(w > hw ? hw : w)+'px'});
			}
		},
		mouseout: function()
		{
			// $(this).removeAttr('style');
			$(this).css({'position':'relative', 'z-index':'', 'width':'auto'});
		},
		dblclick: function()
		{
			//Create text area on top of code on double click
			//This can make copying of the code easier

			var jthis = $(this);
			if (!jthis.data('hasTextArea')) {
				var code = jthis.find(".theCode").html();
				var ta = $('<textarea spellcheck="false"/>');
				ta.html(code);

				var pre = jthis.find('.code > pre');

				ta.css({
					'font-family': pre.css('font-family'),
					'font-size': pre.css('font-size'),
					'line-height': pre.css('line-height'),
					'height': "100%",
					'width': "100%",
					'position': 'absolute',
					'top': 0,
					'left': 0,
					'margin': pre.css('margin'),
					'padding': pre.css('padding'),
					'border': '0px'
				});

				ta.css('resize','none');
				ta.css('outline','none');

				ta.focusout(function(){
					ta.remove();
					jthis.data('hasTextArea',false);
				});

				//readjust position and width if using line numbers
				var line_numbers = jthis.find(".line_numbers");
				if (line_numbers.length != 0) {
					var w = line_numbers.outerWidth();
					ta.css('left',w+"px");
					ta.css('width', jthis.width()-w+"px");
				}
				//readjust position and height if using caption
				var caption = jthis.find('caption');
				if (caption.length != 0) {
					var h = caption.outerHeight();
					ta.css('top',h+"px");
					ta.css('height',jthis.height()-h+"px");
				}

				ta.appendTo(jthis);

				ta.select();
				ta.focus();

				jthis.data('hasTextArea',true);

			}
		}
	});
});


}
/*
     FILE ARCHIVED ON 01:11:55 Dec 09, 2019 AND RETRIEVED FROM THE
     INTERNET ARCHIVE ON 10:45:48 Mar 28, 2023.
     JAVASCRIPT APPENDED BY WAYBACK MACHINE, COPYRIGHT INTERNET ARCHIVE.

     ALL OTHER CONTENT MAY ALSO BE PROTECTED BY COPYRIGHT (17 U.S.C.
     SECTION 108(a)(3)).
*/
/*
playback timings (ms):
  captures_list: 101.534
  exclusion.robots: 0.081
  exclusion.robots.policy: 0.071
  RedisCDXSource: 0.716
  esindex: 0.008
  LoadShardBlock: 75.344 (3)
  PetaboxLoader3.datanode: 91.001 (4)
  load_resource: 337.119
  PetaboxLoader3.resolve: 317.276
*/