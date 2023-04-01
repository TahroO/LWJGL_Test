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

(function(_ds){var window=this;/*

 Copyright The Closure Library Authors.
 SPDX-License-Identifier: Apache-2.0
*/
var bT=_ds.eh(function(){return!_ds.Sd||0<=_ds.Ha(_ds.BI,9)}),cT=_ds.eh(function(){return _ds.Xd||_ds.Ud||_ds.Wd&&0<=_ds.Ha(_ds.BI,10)||_ds.Sd&&0<=_ds.Ha(_ds.BI,10)}),eT=function(a,b){bT()&&(b=cT()?"translate3d("+b+"px,0px,0px)":"translate("+b+"px,0px)",_ds.Hk(a,dT(),b))},dT=_ds.eh(function(){return _ds.Sd&&9==_ds.oe?"-ms-transform":"transform"});var hT=function(a){a.j=fT(a,".devsite-top-logo-row-wrapper-wrapper");a.h=fT(a,".devsite-collapsible-section");a.v=fT(a,".devsite-doc-set-nav-row");a.setAttribute("top-row--height",`${a.j}`);a.setAttribute("bottom-row--height",`${a.h}`);a.setAttribute("bottom-tabs--height",`${a.v}`);gT(a)},gT=function(a){const b=a.querySelector(".devsite-collapsible-section");a.offset>=a.h&&!a.hasAttribute("bottom-row--hidden")?a.setAttribute("bottom-row--hidden",""):a.offset<a.h-a.v&&a.hasAttribute("bottom-row--hidden")&&
a.removeAttribute("bottom-row--hidden");b&&a.offset!==a.H&&(_ds.Hk(b,"transform",`translate3d(0, -${a.offset}px, 0)`),iT(a),a.H=a.offset);document.body.style.setProperty("--devsite-js-header-height",`${a.C()}px`)},jT=function(a){var b=a.querySelector(".devsite-top-logo-row-middle");const c=a.querySelector("devsite-search"),d=a.querySelector(".devsite-search-background");if(b&&c&&d){_ds.K(a.F);a.D&&window.cancelAnimationFrame(a.D);c.removeAttribute("transition");a.removeAttribute("search-expanded");
var e=new _ds.rh(b.offsetWidth,b.offsetHeight);b=new _ds.rh(c.offsetWidth,c.offsetHeight);var f=_ds.$k(c,"margin"),g="rtl"===document.documentElement.getAttribute("dir")?1:-1,h=(e.width-f.left-f.right)/b.width;e=(e.width-(b.width+f.left+f.right))*g;var k=(f=a.hasAttribute("search-active"))?e:0,l=f?h:1;_ds.Hk(d,{opacity:1,width:`${b.width}px`,height:`${b.height}px`});eT(c,a.hasAttribute("search-active")?0:e);_ds.Bk(a.F,d,_ds.kf,()=>{const m=a.querySelector("devsite-search"),n=a.querySelector(".devsite-search-background");
n&&(n.style.opacity="0");m&&(m.removeAttribute("transition"),eT(m,0),a.hasAttribute("search-active")?a.setAttribute("search-expanded",""):a.removeAttribute("search-expanded"))});a.D=window.requestAnimationFrame(()=>{c.setAttribute("transition","");if(bT()){var m=cT()?"scale3d("+l+",1,1)":"scale("+l+",1)";_ds.Hk(d,dT(),m)}eT(c,k)})}},kT=async function(a,b){if(a.hasAttribute("billboard")){var c=a.querySelector("devsite-search"),d=a.querySelector("devsite-search input.devsite-search-query");a=a.querySelector(".devsite-header-billboard-search devsite-search");
var e=null===a||void 0===a?void 0:a.querySelector("input.devsite-search-query");c&&d&&a&&e&&(b?(c.removeAttribute("disabled"),document.activeElement===e&&(await _ds.mj(),d.focus()),a.setAttribute("disabled","")):(a.removeAttribute("disabled"),document.activeElement===d&&e.focus(),c.setAttribute("disabled","")))}},mT=function(a){a.eventHandler.listen(a,"devsite-search-toggle",b=>{b=b.X;_ds.li(b.target,null,"devsite-top-logo-row-middle",void 0)&&(b.detail.active?a.setAttribute("search-active",""):a.removeAttribute("search-active"))});
a.eventHandler.listen(document.body,"devsite-sitemask-hidden",()=>document.body.removeAttribute("devsite-book-nav--open"));a.eventHandler.listen(window,"resize",()=>lT(a));a.eventHandler.listen(document.body,["devsite-page-loaded","devsite-content-updated"],()=>{lT(a)});a.eventHandler.listen(a,"click",b=>{b.defaultPrevented||"devsite-hamburger-menu"!==b.target.getAttribute("id")||(b.preventDefault(),b.stopPropagation(),document.body.setAttribute("devsite-book-nav--open",""),a.dispatchEvent(new CustomEvent("devsite-sitemask-show",
{bubbles:!0})))})},nT=function(a){if(!a.querySelector(".devsite-search-background")&&(a=a.querySelector(".devsite-top-logo-row-middle"))){const b=document.createElement("div");b.classList.add("devsite-search-background");b.style.opacity="1";a.appendChild(b)}},iT=function(a){0===a.h?a.setAttribute("no-lower-row",""):a.removeAttribute("no-lower-row");a.querySelector(".devsite-header-billboard")?a.setAttribute("billboard",""):a.removeAttribute("billboard")},lT=function(a){window.requestAnimationFrame(()=>
a.L.ua())},fT=function(a,b){return(a=a.querySelector(b))?a.getBoundingClientRect().height:0},oT=function(a,b){for(var c=0;c<b.attributes.length;++c){var d=b.attributes.item(c);a.hasAttribute(d.name)||b.removeAttribute(d.name)}for(c=0;c<a.attributes.length;++c)d=a.attributes.item(c),b.setAttribute(d.name,d.value)},pT=function(a,b,c){b=b.querySelector(c);c=a.querySelector(c);b&&c&&(a.updated=!0,_ds.Wg(a,c,b))},qT=class extends _ds.H{constructor(){super(...arguments);this.eventHandler=new _ds.J;this.H=
-1;this.F=new _ds.J;this.D=0;this.G=new MutationObserver(()=>hT(this));this.L=new _ds.xk(()=>{hT(this);iT(this)},15);this.authUser=void 0;this.offset=this.v=this.h=this.j=0;this.updated=!1}static get observedAttributes(){return["offset","search-active","bottom-row--hidden"]}attributeChangedCallback(a,b,c){switch(a){case "offset":this.offset=Number(this.getAttribute("offset")||"")||0;gT(this);break;case "search-active":jT(this);break;case "bottom-row--hidden":a=null!==c,b=this.querySelector("devsite-search input.devsite-search-query"),
c=this.querySelector(".devsite-header-billboard-search devsite-search input.devsite-search-query"),b&&c&&(a?b.value=c.value:c.value=b.value),kT(this,a)}}connectedCallback(){mT(this);nT(this);iT(this);hT(this);this.G.observe(this,{childList:!0,subtree:!0});gT(this);const a=_ds.I();this.authUser=_ds.Oi(_ds.Pi(a.href),"authuser")}disconnectedCallback(){_ds.K(this.eventHandler);this.G.disconnect()}C(){return this.j+this.h-this.offset}J(){return this.j+this.h}Wa(a){this.updated=!1;if(a){pT(this,a,".devsite-header-upper-tabs");
pT(this,a,".devsite-collapsible-section");pT(this,a,".devsite-product-name-wrapper");pT(this,a,"devsite-language-selector");pT(this,a,"devsite-shell-activate-button");var b=a.querySelector("devsite-search"),c=this.querySelector("devsite-search");b&&c&&oT(b,c);c=a.querySelector("devsite-user");b=this.querySelector("devsite-user");c&&b&&(oT(c,b),c=_ds.I(),c=_ds.Oi(_ds.Pi(c.href),"authuser"),c!==this.authUser&&(this.authUser=c,b.refresh()));_ds.Wg(this,this.querySelector("cloudx-additional-tabs"),a.querySelector("cloudx-additional-tabs"),
this.querySelector(".devsite-top-logo-row-middle"));_ds.Wg(this,this.querySelector(".devsite-header-link"),a.querySelector(".devsite-header-link"),this.querySelector("devsite-language-selector"))}!this.updated&&a&&(_ds.Th(this),this.appendChild(a));nT(this);lT(this)}};try{window.customElements.define("devsite-header",qT)}catch(a){console.warn("devsite.app.customElement.DevsiteHeader",a)};})(_ds_www);


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
  captures_list: 84.969
  exclusion.robots: 0.07
  exclusion.robots.policy: 0.059
  cdx.remote: 0.078
  esindex: 0.008
  LoadShardBlock: 55.317 (3)
  PetaboxLoader3.datanode: 137.781 (5)
  load_resource: 284.591 (2)
  PetaboxLoader3.resolve: 193.061 (2)
*/