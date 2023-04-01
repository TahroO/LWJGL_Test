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

(function(_ds){var window=this;var BN=function(a){var b=a.La;a=a.eb;return(0,_ds.V)('<div class="devsite-badger-award-inner"><devsite-badge-awarded badge-name="'+_ds.X(b.title)+'" badge-icon-url="'+_ds.X(_ds.Y(b.imageUrl))+'" badge-url="'+_ds.X(_ds.Y(b.url))+'"'+(null!=b.currentTierCount?' badge-count="'+_ds.X(b.currentTierCount)+'"':"")+(null!=b.complete?' badge-complete="'+_ds.X(b.complete)+'"':"")+(null!=b.isNewTier?' is-new-tier="'+_ds.X(b.isNewTier)+'"':"")+(b.path?' badge-path="'+_ds.X(b.path)+'"':"")+(b.shareTitle?' badge-share-title="'+
_ds.X(b.shareTitle)+'"':"")+(b.shareDescription?' badge-share-description="'+_ds.X(b.shareDescription)+'"':"")+(b.nextPlaylistUrl?' next-playlist-url="'+_ds.X(_ds.Y(b.nextPlaylistUrl))+'"':"")+(b.redeemAnotherBtn?" redeem-another":"")+(b.hideButtons?" hide-buttons":"")+(b.redeemCode?' redeem-code="'+_ds.X(b.redeemCode)+'"':"")+(a?' return-uri="'+_ds.X(_ds.Y(a))+'"':"")+" dismiss></devsite-badge-awarded></div>")},CN=function(){return(0,_ds.V)('<div class="devsite-badger-award"></div>')};var DN=/\/redeem.*|\/u[\/]?.*|\/settings[\/]?.*?/,HN=function(a){a.eventHandler.listen(document.body,"devsite-before-page-change",()=>void EN(a));a.eventHandler.listen(document.body,"devsite-award-granted",b=>{(b=b.X)&&b.detail&&FN(a,b.detail.award)});a.eventHandler.listen(document.body,["devsite-page-loaded","devsite-page-changed"],()=>{a.ed();GN(a)})},EN=async function(a){if(a.h){var b=a.h.querySelectorAll(".devsite-badger-award-inner"),c=b[0];if(c){const d=c.querySelector("devsite-badge-awarded");
if(null===d||void 0===d?0:d.j)null===d||void 0===d?void 0:d.j();const e=null===d||void 0===d?void 0:d.getAttribute("badge-path");a.Sa=a.Sa.filter(f=>f.path!==e);c.removeAttribute("show");await _ds.nj(200);_ds.Vh(c);1===b.length&&(_ds.Vh(a.h),a.h=null)}}},FN=async function(a,b){var c;if(b&&b.complete&&!a.Sa.find(f=>f.path===b.path)&&"error"!==document.body.getAttribute("type")&&!DN.exec(document.location.pathname)){a.Sa.push(b);if(!a.h){var d=document.querySelector(".static-badge-awarded-container");
d?(a.h=d,a.v=!0):(a.h=_ds.R(CN),document.body.appendChild(a.h))}try{await window.customElements.whenDefined("devsite-badge-awarded")}catch(f){}d=null===(c=_ds.ij())||void 0===c?void 0:c.href;var e=_ds.R(BN,{La:b,eb:d});e&&(a.eventHandler.listen(e,"devsite-badge-awarded-dismissed",()=>{EN(a)}),d=e.querySelector("devsite-badge-awarded"))&&(a.h.appendChild(e),_ds.Bk(a.eventHandler,d,"running",()=>{null===e||void 0===e?void 0:e.setAttribute("show","");var f,g;const h=null===(f=a.h)||void 0===f?void 0:
f.querySelectorAll("devsite-badge-awarded");if(h&&!a.v)for(f=0;f<h.length;f++)null===(g=h[f])||void 0===g?void 0:g.dispatchEvent(new CustomEvent("devsite-badge-awarded-stack-num-changed",{bubbles:!0,detail:{Zm:h.length-1-f}}))}))}},GN=function(a){if(_ds.hm(a.j)){var b=_ds.HF();if(b){b=b.filter(c=>3>c.displayCount);0<b.length?a.j.set("temp_badges",JSON.stringify(b)):a.j.remove("temp_badges");for(const c of b){b=new URL(c.awardedBy,document.location.origin);const d=_ds.I();(!c.awardedBy||b.origin===
d.origin&&b.pathname===d.pathname)&&c.complete&&FN(a,c)}}}},IN=class extends _ds.fG{constructor(){super(["devsite-badge-awarded"]);this.eventHandler=new _ds.J(this);this.j=new _ds.im;this.h=null;this.Sa=[];this.v=!1}connectedCallback(){HN(this)}disconnectedCallback(){_ds.K(this.eventHandler);EN(this)}async ed(){await _ds.A();await window.customElements.whenDefined("devsite-user");var a=document.querySelector("devsite-user#devsite-user");if(a){var b=!1;try{b=await a.isSignedIn()}catch(c){}if(b&&await (new _ds.gx).Zb()){a=
new _ds.cx;try{await a.W()}catch(c){}}}}};try{window.customElements.define("devsite-badger",IN)}catch(a){console.warn("Unrecognized DevSite custom element - DevsiteBadger",a)};})(_ds_www);


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
  captures_list: 195.538
  exclusion.robots: 0.065
  exclusion.robots.policy: 0.058
  cdx.remote: 0.054
  esindex: 0.009
  LoadShardBlock: 172.085 (3)
  PetaboxLoader3.datanode: 216.855 (5)
  load_resource: 242.816 (2)
  PetaboxLoader3.resolve: 157.27 (2)
*/