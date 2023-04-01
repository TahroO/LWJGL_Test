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

(function(_ds){var window=this;var LT=async function(a){const b=a.h.get("django_language");b&&await a.j.set("language_preference",b)},MT=async function(a){if(!a.h.get("django_language")){const b=await _ds.A();a.h.set("django_language",b.getLocale()||"en",{Ab:15552E3,path:"/"})}},OT=function(a){_ds.K(a.eventHandler);const b=a.querySelector(".devsite-language-selector-select");b&&a.eventHandler.listen(b,"change",c=>{NT(a,c)})},NT=async function(a,b){await _ds.A();a.h.remove("django_language");b=b.target;a.h.set("django_language",
b.value,{Ab:15552E3,path:"/"});const c=document.documentElement.getAttribute("lang");c&&await PT(a,c,b.value);await LT(a);a=new URL(_ds.Oh().location.toString());a.searchParams.delete("hl");a=_ds.Wc(a.toString());_ds.Oh().location.assign(_ds.Ic(a))},PT=async function(a,b,c){a.dispatchEvent(new CustomEvent("devsite-analytics-observation",{detail:{category:"Site-Wide Custom Events",label:"Language Selector",action:`${b} to ${c}`},bubbles:!0}));b={eventData:JSON.stringify({name:"change",type:"languageSelector",
metadata:{"selected-language":`${c}`,"original-language":`${b}`}})};a.dispatchEvent(new CustomEvent("devsite-analytics-observation-cloudtrack",{detail:b,bubbles:!0}))},QT=class extends _ds.H{constructor(){super(...arguments);this.j=_ds.rl();this.eventHandler=new _ds.J;this.h=new _ds.wo(document)}async connectedCallback(){try{await MT(this),await LT(this)}catch(a){}OT(this)}disconnectedCallback(){_ds.K(this.eventHandler)}Wa(a){a&&(_ds.Wg(this,this.querySelector(".devsite-language-selector-menu"),a.querySelector(".devsite-language-selector-menu")),
OT(this))}};QT.prototype.updateContent=QT.prototype.Wa;QT.prototype.disconnectedCallback=QT.prototype.disconnectedCallback;QT.prototype.connectedCallback=QT.prototype.connectedCallback;try{window.customElements.define("devsite-language-selector",QT)}catch(a){console.warn("devsite.app.customElement.DevsiteLanguageSelector",a)};})(_ds_www);


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
  captures_list: 85.824
  exclusion.robots: 0.064
  exclusion.robots.policy: 0.055
  RedisCDXSource: 0.65
  esindex: 0.007
  LoadShardBlock: 66.09 (3)
  PetaboxLoader3.datanode: 97.531 (5)
  load_resource: 589.787 (2)
  PetaboxLoader3.resolve: 516.555 (2)
*/