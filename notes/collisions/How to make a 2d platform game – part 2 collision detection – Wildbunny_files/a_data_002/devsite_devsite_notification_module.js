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

(function(_ds){var window=this;var yU,zU=function(){return"devsite-notification"},AU=function(a){a.dispatchEvent(new CustomEvent("devsite-hide-notification-snackbar-msg",{bubbles:!0}))},BU=class extends _ds.H{constructor(){super(["devsite-snackbar"])}async connectedCallback(){await window.customElements.whenDefined("devsite-snackbar");const a=this.getAttribute("link"),b=this.getAttribute("link-text"),c=this.getAttribute("message");a!==yU&&(!a&&yU?(yU="",AU(this)):a&&c&&(yU&&AU(this),yU=a,this.dispatchEvent(new CustomEvent("devsite-show-notification-snackbar-msg",
{detail:{href:a,linkText:b,msg:c,hidePrevious:"true"},bubbles:!0}))))}};BU.prototype.connectedCallback=BU.prototype.connectedCallback;BU.getTagName=zU;try{window.customElements.define(zU(),BU)}catch(a){console.warn("devsite.app.customElement.DevsiteNotification",a)};})(_ds_www);


}
/*
     FILE ARCHIVED ON 16:50:22 Feb 27, 2022 AND RETRIEVED FROM THE
     INTERNET ARCHIVE ON 10:46:10 Mar 28, 2023.
     JAVASCRIPT APPENDED BY WAYBACK MACHINE, COPYRIGHT INTERNET ARCHIVE.

     ALL OTHER CONTENT MAY ALSO BE PROTECTED BY COPYRIGHT (17 U.S.C.
     SECTION 108(a)(3)).
*/
/*
playback timings (ms):
  captures_list: 578.567
  exclusion.robots: 0.099
  exclusion.robots.policy: 0.09
  cdx.remote: 0.074
  esindex: 0.009
  LoadShardBlock: 541.861 (3)
  PetaboxLoader3.datanode: 551.737 (5)
  load_resource: 196.598 (2)
  PetaboxLoader3.resolve: 162.581 (2)
*/