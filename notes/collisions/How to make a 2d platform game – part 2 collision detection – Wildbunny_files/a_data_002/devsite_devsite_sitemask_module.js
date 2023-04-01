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

(function(_ds){var window=this;var aZ=class extends _ds.H{constructor(){super();this.eventHandler=new _ds.J}static get observedAttributes(){return["visible"]}connectedCallback(){this.eventHandler.listen(document.body,"devsite-sitemask-show",()=>this.show());this.eventHandler.listen(document.body,"keydown",a=>{"Escape"===a.key&&this.hasAttribute("visible")&&(a.preventDefault(),a.stopPropagation(),this.ob())});this.eventHandler.listen(document.body,"devsite-sitemask-hide",()=>this.ob());this.eventHandler.listen(this,"click",()=>
this.ob())}attributeChangedCallback(a,b,c){"visible"===a&&(null==c?this.dispatchEvent(new CustomEvent("devsite-sitemask-hidden",{bubbles:!0})):this.dispatchEvent(new CustomEvent("devsite-sitemask-visible",{bubbles:!0})))}disconnectedCallback(){_ds.K(this.eventHandler)}show(){this.setAttribute("visible",this.getAttribute("visible")||"")}ob(){this.removeAttribute("visible")}};aZ.prototype.hide=aZ.prototype.ob;aZ.prototype.show=aZ.prototype.show;aZ.prototype.disconnectedCallback=aZ.prototype.disconnectedCallback;
aZ.prototype.attributeChangedCallback=aZ.prototype.attributeChangedCallback;aZ.prototype.connectedCallback=aZ.prototype.connectedCallback;try{window.customElements.define("devsite-sitemask",aZ)}catch(a){console.warn("Unrecognized DevSite custom element - DevsiteSitemask",a)};})(_ds_www);


}
/*
     FILE ARCHIVED ON 16:21:35 Feb 27, 2022 AND RETRIEVED FROM THE
     INTERNET ARCHIVE ON 10:46:10 Mar 28, 2023.
     JAVASCRIPT APPENDED BY WAYBACK MACHINE, COPYRIGHT INTERNET ARCHIVE.

     ALL OTHER CONTENT MAY ALSO BE PROTECTED BY COPYRIGHT (17 U.S.C.
     SECTION 108(a)(3)).
*/
/*
playback timings (ms):
  captures_list: 107.885
  exclusion.robots: 0.093
  exclusion.robots.policy: 0.082
  cdx.remote: 0.074
  esindex: 0.01
  LoadShardBlock: 74.834 (3)
  PetaboxLoader3.datanode: 288.578 (5)
  load_resource: 390.361 (2)
  PetaboxLoader3.resolve: 168.39 (2)
*/