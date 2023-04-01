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

(function() {
  var write_string="<iframe src=\"//www.redditstatic.com/button/button1.html?url=";

  if (window.reddit_url)  { 
      write_string += encodeURIComponent(reddit_url); 
  }
  else { 
      write_string += encodeURIComponent(window.location.href);
  }
  if (window.reddit_title) {
       write_string += '&title=' + encodeURIComponent(window.reddit_title);
  }
  if (window.reddit_target) {
       write_string += '&sr=' + encodeURIComponent(window.reddit_target);
  }
  if (window.reddit_css) {
      write_string += '&css=' + encodeURIComponent(window.reddit_css);
  }
  if (window.reddit_bgcolor) {
      write_string += '&bgcolor=' + encodeURIComponent(window.reddit_bgcolor); 
  }
  if (window.reddit_bordercolor) {
      write_string += '&bordercolor=' + encodeURIComponent(window.reddit_bordercolor); 
  }
  if (window.reddit_newwindow) { 
      write_string += '&newwindow=' + encodeURIComponent(window.reddit_newwindow);}
  write_string += "\" height=\"22\" width=\"120\" scrolling='no' frameborder='0'></iframe>";
  document.write(write_string);
})()


}
/*
     FILE ARCHIVED ON 03:53:51 Dec 06, 2019 AND RETRIEVED FROM THE
     INTERNET ARCHIVE ON 10:45:47 Mar 28, 2023.
     JAVASCRIPT APPENDED BY WAYBACK MACHINE, COPYRIGHT INTERNET ARCHIVE.

     ALL OTHER CONTENT MAY ALSO BE PROTECTED BY COPYRIGHT (17 U.S.C.
     SECTION 108(a)(3)).
*/
/*
playback timings (ms):
  captures_list: 1387.726
  exclusion.robots: 0.078
  exclusion.robots.policy: 0.066
  RedisCDXSource: 0.624
  esindex: 0.009
  LoadShardBlock: 266.899 (4)
  PetaboxLoader3.datanode: 81.771 (5)
  PetaboxLoader3.resolve: 241.917 (3)
  load_resource: 86.748
*/