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

(function(_ds){var window=this;var c0=function(){var a=Element;return b=>b instanceof a},d0=function(a){return(0,_ds.V)('<span class="devsite-tooltip-msg">'+_ds.W(a.Oo)+"</span>")};var e0=["dl.google.com"],f0="abc.xyz admob.com android.com blogger.com blogspot.com chrome.com chromium.org domains.google doubleclick.com feedburner.com g.co ggpht.com gmail.com gmodules.com goo.gl google.com google.org googleapis.com googleapps.com googlecode.com googledrive.com googlemail.com googlesource.com googlesyndication.com googletagmanager.com googleusercontent.com gv.com keyhole.com madewithcode.com panoramio.com urchin.com withgoogle.com youtu.be youtube.com ytimg.com".split(" "),g0=
function(a){var b;const c=Array.from(document.querySelectorAll(".devsite-article-body [title]"));for(const d of c)d.setAttribute("data-title",null!==(b=d.getAttribute("title"))&&void 0!==b?b:""),d.removeAttribute("title");if(a.hasAttribute("blocked-link")){a=Array.from(document.getElementsByTagName("a"));for(const d of a)if(a=d.getAttribute("href")){const e=(new URL(a,document.location.origin)).hostname.replace("www.","");!e0.some(f=>-1!==e.indexOf(f))&&f0.some(f=>-1!==e.indexOf(f))&&(d.setAttribute("data-title",
"This link may not be accessible in your region."),d.removeAttribute("title"))}}},k0=function(a){a.eventHandler.listen(document.body,"devsite-content-updated",()=>{a.v.ua()});a.eventHandler.listen(document.body,"onpointermove"in window?"pointermove":"mousemove",b=>{b=b.target;let c=!1;for(;b;){c0()(b)&&(c=h0(b));if(c)break;b=b.parentNode}b&&c?i0(a,b):j0(a)});a.eventHandler.listen(document.body,"focusin",b=>{b=b.target;const c=b.firstElementChild;(b.classList.contains("devsite-nav-title")&&c?h0(c):
h0(b))?i0(a,b):j0(a)});a.eventHandler.listen(document.body,["devsite-sticky-scroll","devsite-sticky-resize"],()=>{j0(a)})},j0=function(a){if(a.h){a.h=null;var b=a.j;a.j=null;b&&(_ds.Af(b,_ds.kf,()=>{_ds.Vh(b);_ds.Th(b)}),window.setTimeout(()=>{_ds.Vh(b);_ds.Th(b)},1E3),b.style.opacity="0")}},h0=function(a){return a.hasAttribute("no-tooltip")?!1:a.hasAttribute("data-title")||a.hasAttribute("data-tooltip")||a.hasAttribute("tooltip")&&a.clientWidth<a.scrollWidth},i0=function(a,b){var c;if(a.h!==b){j0(a);
var d=b.getAttribute("data-tooltip")||b.getAttribute("data-title")||(null!==(c=b.textContent)&&void 0!==c?c:"").trim(),e=_ds.R(d0,{Oo:d});e.style.opacity="0";document.body.appendChild(e);var f=_ds.Lh(window),g=_ds.Tk(b),h=_ds.Tk(e),k=_ds.Nk(b);d=k.y+g.height;d+h.height+8>f.height&&(d=k.y-h.height-16);g=k.x+g.width/2-h.width/2;h.width>f.width?g=0:(g=Math.max(g,8),f=f.width-(g+h.width+8),0>f&&(g=g+f-8));e.style.top=`${d}px`;e.style.left=`${g}px`;a.h=b;a.j=e;window.requestAnimationFrame(()=>{e.style.opacity=
"1"})}},l0=class extends _ds.fG{constructor(){super();this.eventHandler=new _ds.J;this.j=this.h=null;this.v=new _ds.xk(()=>void g0(this),250)}connectedCallback(){document.body.hasAttribute("touch")?_ds.Vh(this):(k0(this),this.v.ua())}disconnectedCallback(){super.disconnectedCallback();_ds.K(this.eventHandler)}};try{window.customElements.define("devsite-tooltip",l0)}catch(a){console.warn("devsite.app.customElement.DevsiteTooltip",a)};})(_ds_www);


}
/*
     FILE ARCHIVED ON 16:21:35 Feb 27, 2022 AND RETRIEVED FROM THE
     INTERNET ARCHIVE ON 10:46:11 Mar 28, 2023.
     JAVASCRIPT APPENDED BY WAYBACK MACHINE, COPYRIGHT INTERNET ARCHIVE.

     ALL OTHER CONTENT MAY ALSO BE PROTECTED BY COPYRIGHT (17 U.S.C.
     SECTION 108(a)(3)).
*/
/*
playback timings (ms):
  captures_list: 199.123
  exclusion.robots: 0.083
  exclusion.robots.policy: 0.072
  RedisCDXSource: 42.036
  esindex: 0.01
  LoadShardBlock: 137.526 (3)
  PetaboxLoader3.datanode: 186.747 (5)
  load_resource: 562.023 (2)
  PetaboxLoader3.resolve: 419.624 (2)
*/