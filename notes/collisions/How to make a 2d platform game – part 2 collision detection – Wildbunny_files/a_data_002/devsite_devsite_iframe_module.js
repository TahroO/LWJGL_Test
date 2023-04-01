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

(function(_ds){var window=this;var xT=["height","width"],yT=async function(a){if(!a.h){var b=await _ds.A();const e=a.querySelector("iframe");if(e){var c=e.classList.contains("inherit-locale");e.classList.remove("framebox");e.classList.remove("inherit-locale");e.removeAttribute("style");e.removeAttribute("is-upgraded");var d=e.dataset.src||e.src;if(d){d=new URL(d,document.location.origin);const f=new _ds.Ai(d.href);(b=b.getLocale())&&c&&_ds.Ni(f,"hl",b);d.search=f.h.toString();e.removeAttribute("data-src");e.src!==d.href&&(e.src=
d.href)}for(const f in xT)e.hasAttribute(f)&&(a.setAttribute(f,e.getAttribute(f)||""),e.removeAttribute(f));a.classList.add(...Array.from(e.classList));e.removeAttribute("class");a.h=!0}else console.warn("devsite-iframe is missing an iframe")}},zT=class extends _ds.H{constructor(){super(...arguments);this.h=!1}static get observedAttributes(){return xT}connectedCallback(){yT(this)}attributeChangedCallback(a,b,c){xT.includes(a)&&_ds.Hk(this,a,`${c||""}`)}};zT.prototype.attributeChangedCallback=zT.prototype.attributeChangedCallback;
zT.prototype.connectedCallback=zT.prototype.connectedCallback;try{window.customElements.define("devsite-iframe",zT)}catch(a){console.warn("devsite.app.customElement.DevsiteIframe",a)};})(_ds_www);


}
/*
     FILE ARCHIVED ON 02:27:42 Feb 27, 2022 AND RETRIEVED FROM THE
     INTERNET ARCHIVE ON 10:46:11 Mar 28, 2023.
     JAVASCRIPT APPENDED BY WAYBACK MACHINE, COPYRIGHT INTERNET ARCHIVE.

     ALL OTHER CONTENT MAY ALSO BE PROTECTED BY COPYRIGHT (17 U.S.C.
     SECTION 108(a)(3)).
*/
/*
playback timings (ms):
  captures_list: 111.068
  exclusion.robots: 0.088
  exclusion.robots.policy: 0.076
  cdx.remote: 0.07
  esindex: 0.009
  LoadShardBlock: 83.602 (3)
  PetaboxLoader3.datanode: 187.867 (5)
  load_resource: 306.896 (2)
  PetaboxLoader3.resolve: 179.322 (2)
*/