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

(function(_ds){var window=this;var GP=function(a){return!a.classList.contains("material-icons")},OP=async function(a,b){await DevsiteApp.whenReady();const c=_ds.I();var d=DevsiteApp.getInsecureHost();b=b.X;if(b.origin===c.origin||!d||b.origin===d){try{var e=_ds.Te(_ds.tl,b.data)}catch(g){return}d=_ds.Ce(e,1,0);if(4===d)HP(a,b);else{var f=e.getName();if(f&&(f=a.querySelector(`devsite-iframe iframe[name="${f}"]`)))switch(d){case 5:IP(e,f);break;case 8:JP(b,e,c);break;case 1:KP(b,e,c);break;case 6:case 7:LP(d,c,e);break;case 9:MP(a,
e);break;case 10:NP(e,c)}}}},SP=function(a){a.v=a.querySelector(".devsite-article-body");a.v&&PP(a);a.h&&a.h.disconnect();a.j.clear();QP(a);if(!document.body.hasAttribute("dark-theme")){var b=[...a.querySelectorAll("picture > source.devsite-dark-theme")];for(var c of b){b=c.closest("picture");const d=b.querySelector("img");b.querySelectorAll("source:not(.devsite-dark-theme)").length?c.remove():b&&d&&b.replaceWith(d)}}c=Array.from(a.querySelectorAll(".devsite-nav-title, .devsite-page-title, td > code, th > code"));
"docs"===document.body.getAttribute("layout")&&a.v&&(b=Array.from(a.v.querySelectorAll("h1, h2, h3, h4, h5, h6")),c.push(...b));a.j.clear();a.j=new Set(c);if(_ds.I().hash){c=new _ds.iG;for(const d of a.j)_ds.hG(c,d,GP)}else RP(a,a.j);a.dispatchEvent(new CustomEvent("devsite-content-updated",{bubbles:!0}))},QP=function(a){Array.from(a.getElementsByTagName("table")).forEach(b=>{if(!b.parentNode.classList.contains("devsite-table-wrapper")){var c=document.createElement("div");c.classList.add("devsite-table-wrapper");
b.classList.contains("full-width")&&(c.classList.add("devsite-full-width-table"),b.classList.remove("full-width"));b.parentNode&&b.parentNode.insertBefore(c,b);c.appendChild(b)}})},HP=async function(a,b){var c=TP(a,b.source);c&&(a="goog_"+_ds.Bh++,c.setAttribute("name",a),c=_ds.ul(3),a=_ds.Re(c,2,a),(b=b.source)&&b.postMessage(_ds.Ue(a),"*"))},IP=async function(a,b){const c=_ds.Nh(document).y,d=_ds.Me(a,4);a=_ds.Me(a,3);b=_ds.ai(b);d&&b.setAttribute("width",`${d}px`);a&&b.setAttribute("height",`${a}px`);
window.requestAnimationFrame(()=>{window.scrollTo(_ds.Nh(document).x,c)})},JP=async function(a,b,c){b=_ds.vl(_ds.ul(8),_ds.B(b,8));c=_ds.Re(b,6,c.toString());(a=a.source)&&a.postMessage(_ds.Ue(c),"*")},KP=async function(a,b,c){b=_ds.vl(_ds.ul(2),_ds.B(b,8));c=_ds.Re(b,7,`${c.search}${c.hash}`);(a=a.source)&&a.postMessage(_ds.Ue(c),"*")},LP=async function(a,b,c){const d=c.getTitle();b=new URL(c.getUrl(),b.origin);b=`${window.location.origin}${window.location.pathname}${b.search}${b.hash}`;6===a?window.history.pushState({},
d,b):window.history.replaceState({},d,b)},MP=async function(a,b){const c=_ds.B(b,9);b=JSON.parse(_ds.B(b,10));"cloudtrackEvent"===c&&b?a.dispatchEvent(new CustomEvent("devsite-analytics-observation-cloudtrack",{detail:{eventData:b},bubbles:!0})):"devsite-apix"===c&&a.dispatchEvent(new CustomEvent("devsite-apix-observation",{detail:b,bubbles:!0}))},NP=async function(a,b){if(a=a.getUrl()){const c=new URL(a,b.origin);a.startsWith("#")||b.origin===c.origin&&b.pathname===c.pathname&&b.search===c.search?
DevsiteApp.scrollToAnchor(c.hash,!0):DevsiteApp.fetchPage(c.href)}},TP=function(a,b){let c;Array.from(a.querySelectorAll("devsite-iframe iframe")).forEach(d=>{_ds.bi(d)===b&&(c=d)});return c},PP=function(a){"full"===document.body.getAttribute("layout")&&(a=a.v.querySelectorAll('h1[tabindex="0"],h2[tabindex="0"],h3[tabindex="0"],h4[tabindex="0"],h5[tabindex="0"],h6[tabindex="0"]'))&&Array.from(a).forEach(b=>{b.removeAttribute("tabindex")})},RP=function(a,b){a.h&&b.forEach(c=>{a.h.observe(c)})},UP=
class extends _ds.H{constructor(){super();this.C=new _ds.J;this.D=new _ds.J;this.j=new Set;this.h=null;"IntersectionObserver"in window&&(this.h=new IntersectionObserver(a=>{for(const b of a)b.isIntersecting&&(a=b.target,_ds.hG(new _ds.iG,a,GP),this.j.delete(a),this.h.unobserve(a))},{rootMargin:"100%"}))}connectedCallback(){this.C.listen(window,"message",a=>OP(this,a));SP(this)}disconnectedCallback(){this.h&&this.h.disconnect();this.j.clear();_ds.K(this.C);_ds.K(this.D)}Wa(a){a&&([".devsite-article",
".devsite-content-data","devsite-content-footer","devsite-notification"].forEach(b=>{_ds.Wg(this,this.querySelector(b),a.querySelector(b))}),SP(this))}};UP.prototype.updateContent=UP.prototype.Wa;UP.prototype.disconnectedCallback=UP.prototype.disconnectedCallback;UP.prototype.connectedCallback=UP.prototype.connectedCallback;try{window.customElements.define("devsite-content",UP)}catch(a){console.warn("devsite.app.customElement.DevsiteContent",a)};})(_ds_www);


}
/*
     FILE ARCHIVED ON 16:21:35 Feb 27, 2022 AND RETRIEVED FROM THE
     INTERNET ARCHIVE ON 10:46:09 Mar 28, 2023.
     JAVASCRIPT APPENDED BY WAYBACK MACHINE, COPYRIGHT INTERNET ARCHIVE.

     ALL OTHER CONTENT MAY ALSO BE PROTECTED BY COPYRIGHT (17 U.S.C.
     SECTION 108(a)(3)).
*/
/*
playback timings (ms):
  captures_list: 90.808
  exclusion.robots: 0.144
  exclusion.robots.policy: 0.126
  cdx.remote: 0.093
  esindex: 0.015
  LoadShardBlock: 56.357 (3)
  PetaboxLoader3.datanode: 96.634 (5)
  load_resource: 122.04 (2)
  PetaboxLoader3.resolve: 65.728
*/