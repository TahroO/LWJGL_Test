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

(function(_ds){var window=this;var TZ=function(a){var b=a.yh;a=a.columns;let c='<div class="dropdown-tabbed-menu"><ul class="dropdown-tabbed-menu-list">';const d=a.length;for(let e=0;e<d;e++){const f=a[e];c+='<li class="dropdown-tabbed-menu-list-item"><a href="#" column-id="'+_ds.X(f.Sl)+'" tabindex="0" track-type="nav" track-name="'+_ds.X(f.text)+'" track-metadata-eventdetail="#" track-metadata-position="nav - '+_ds.X(b)+'" track-metadata-module="secondary nav">'+_ds.W(f.text)+"</a></li>"}return(0,_ds.V)(c+"</ul></div>")},UZ=
function(a){var b=a.yh,c=a.href;a=a.text;return(0,_ds.V)('<div class="dropdown-tabbed-menu-button"><a href="'+_ds.X(_ds.Y(c))+'" track-type="nav" track-name="'+_ds.X(a)+'" track-metadata-eventdetail="'+_ds.X(c)+'" track-metadata-position="nav - '+_ds.X(b)+'" track-metadata-module="secondary nav">'+_ds.W(a)+"</a></div>")};var VZ=function(a){var b;a.Fb=Array.from(a.querySelectorAll("tab"));let c=a.querySelector(".devsite-tabs-wrapper");c||(c=a.ownerDocument.createElement("div"),c.classList.add("devsite-tabs-wrapper"),a.appendChild(c),null===(b=a.Fb)||void 0===b?void 0:b.forEach(f=>null===c||void 0===c?void 0:c.appendChild(f)));a.v=c;a.appendChild(c);if(!a.hasAttribute("no-overflow")){var d=a.ownerDocument.createElement("tab");_ds.F(a,"overflow-tab","",d);var e=a.ownerDocument.createElement("a");_ds.ih(e,"#");e.textContent=
"More";e.classList.add("devsite-icon");e.classList.add("devsite-icon-arrow-drop-down");d.appendChild(e);a.h=d;e=a.ownerDocument.createElement("div");e.classList.add("devsite-tabs-overflow-menu");_ds.F(a,"scrollbars","",e);_ds.F(a,"hidden","",e);a.D=e;d.appendChild(e);c.appendChild(d)}},ZZ=function(a){var b;null===(b=a.Fb)||void 0===b?void 0:b.forEach(async(c,d)=>{if(await WZ(c)){var e=Array.from(c.querySelectorAll(".devsite-tabs-dropdown-column")),f=c.querySelector(".devsite-tabs-dropdown"),g=c.querySelector("a");
e.forEach((h,k)=>{_ds.F(a,"column-id",`tab-${d}-column-${k}`,h)});e=e.map(h=>{const k=h.querySelector(".devsite-nav-title")||h.querySelector(".devsite-nav-item-title");return{Sl:h.getAttribute("column-id"),text:null===k||void 0===k?void 0:k.textContent}});g&&(g=_ds.R(TZ,{yh:(g.textContent||"").toLowerCase().trim(),columns:e}),f&&(e=c.querySelector(".devsite-tabs-dropdown-content")))&&(f.insertBefore(g,e),f=c.querySelector(".dropdown-tabbed-menu a"),XZ(c),a.eventHandler.listen(g,"click",h=>{h.preventDefault();
const k=c.querySelector(".dropdown-tabbed-menu-button");h=h.target;k&&h.tagName&&"a"===h.tagName.toLowerCase()&&!k.contains(h)&&YZ(a,c,(null===h||void 0===h?void 0:h.getAttribute("column-id"))||"")}),f&&YZ(a,c,f.getAttribute("column-id")||""))}})},$Z=function(a,b){if(!b)return 0;const c=[];let d=b;for(;d.parentElement&&0===d.offsetWidth;)c.push(d),_ds.F(a,"render-hidden","",d),d=d.parentElement;a=_ds.Tk(b).width;for(const e of c)e.removeAttribute("render-hidden");return a},h_=function(a){a.eventHandler.listen(document.body,
"devsite-sticky-resize",()=>a.G.ua());a.eventHandler.listen(a,"click",c=>{if(!(c.shiftKey||c.ctrlKey||c.metaKey||c.altKey)){var d=c.target,e=a.C(d);if(e)if(e===a.h)a_(a,c);else if(b_(a),d.classList.contains("devsite-tabs-dropdown-toggle"))c.preventDefault(),c.stopPropagation(),e.hasAttribute("dropdown--open")?c_(a):d_(a,e);else{var f;"A"===d.tagName?f=d:f=_ds.li(d,"A");var g=e.querySelector(".devsite-tabs-dropdown");g&&g.contains(d)?f&&f.hasAttribute("href")||(c.preventDefault(),c.stopPropagation()):
(a.L(e),f&&f&&"#"!==f.href||a.G.ua())}}});if(a.querySelector("tab[dropdown]")||a.querySelector("tab[overflow-tab]")){var b="onpointermove"in window?"pointerover":"mouseover";const c="onpointermove"in window?"pointerleave":"mouseleave",d=a.querySelectorAll("tab[clickable]");if(d.length){for(const e of d)a.eventHandler.listen(e,"click",f=>{var g;const h=f.target,k=a.C(h),l=null===k||void 0===k?void 0:k.querySelector(".devsite-tabs-dropdown");!l||(null===(g=a.h)||void 0===g?0:g.contains(h))||l.contains(h)||
(f.preventDefault(),f.stopPropagation(),(null===k||void 0===k?0:k.hasAttribute("dropdown--open"))?c_(a):e_(a,f))});a.eventHandler.listen(document.body,"click",e=>{a.v&&!a.v.contains(e.target)&&c_(a)})}else a.eventHandler.listen(a,b,e=>void f_(a,e)),a.eventHandler.listen(a,c,()=>void g_(a))}b=[...a.querySelectorAll(".devsite-tabs-close-button")];for(const c of b)a.eventHandler.listen(c,"click",()=>c_(a))},i_=function(a){var b,c,d;_ds.F(a,"hidden","",a.h);if(!(a.Fb&&3>a.Fb.length)){var e=$Z(a,a);if(0!==
e){var f=(null===(b=a.Fb)||void 0===b?void 0:b.slice())||[],g=0,h;f.forEach(m=>{m.parentNode!==a.v&&(h?h.parentNode&&h.parentNode.insertBefore(m,h.nextSibling):_ds.Uh(a.v,m,0));h=m;g+=$Z(a,m)});if(!(g<=e)){var k=a.K;null===(c=a.h)||void 0===c?void 0:c.removeAttribute("hidden");var l=a.querySelector("[active]");for(l&&(k+=$Z(a,l));null===f||void 0===f?0:f.length;){const m=f.shift();if(m===l)continue;const n=$Z(a,m||null);k+n<=e?k+=n:null===(d=a.D)||void 0===d?void 0:d.appendChild(m)}}}}},f_=async function(a,
b){(await _ds.A()).isTouchEnabled()||e_(a,b)},g_=async function(a){(await _ds.A()).isTouchEnabled()||c_(a,300)},c_=function(a,b=0){_ds.K(a.j);window.clearTimeout(a.F);const c=a.querySelector("tab[dropdown--open]");if(c){const d=c.querySelector(".devsite-tabs-dropdown");_ds.F(a,"dropdown-transition","",d);_ds.Bk(a.j,d,_ds.kf,()=>{null===d||void 0===d?void 0:d.removeAttribute("dropdown-transition");a.removeAttribute("dropdown--open");_ds.F(a,"hidden","",d)});a.F=window.setTimeout(()=>{c.removeAttribute("dropdown--open");
j_(a,c)},b)}else a.removeAttribute("dropdown--open");b_(a)},e_=function(a,b){var c;const d=b.target,e=a.C(d);e&&(e===a.h||(null===(c=a.h)||void 0===c?0:c.contains(d))?a_(a,b):d_(a,e))},a_=async function(a,b){var c;b.preventDefault();b.stopPropagation();document.body.dispatchEvent(new CustomEvent("devsite-close-overflow-tabs"));await _ds.mj();if(!a.hasAttribute("overflow-menu--open")){b=await _ds.A();await b.whenReady();if(b.isTouchEnabled()){const d=e=>{a.contains(e.target)||b_(a);_ds.Ck(a.j,document.body,
["devsite-close-overflow-tabs","click"],d)};a.j.listen(document.body,["devsite-close-overflow-tabs","click"],d)}null===(c=a.D)||void 0===c?void 0:c.removeAttribute("hidden");_ds.F(a,"overflow-menu--open","")}},d_=async function(a,b){b_(a);if(b.hasAttribute("dropdown")){if(_ds.K(a.j),window.clearTimeout(a.F),!b.hasAttribute("dropdown--open")){(await _ds.A()).isTouchEnabled()&&_ds.Bk(a.j,document.body,"click",g=>{a.contains(g.target)||c_(a)});var c=a.querySelector("tab[dropdown--open]"),d=b.querySelector(".devsite-tabs-dropdown");
if(d){d.removeAttribute("hidden");_ds.Hk(d,"left","");var e=_ds.Lh(window||window),f=Array.from(d.querySelectorAll(".devsite-tabs-dropdown-column"));if(!b.hasAttribute("dropdown-full")&&1<f.length){const g=[];f.forEach(k=>{g.push(k.scrollWidth)});const h=Math.max.apply(null,g);h*f.length<e.width?f.forEach(k=>{_ds.Hk(k,"width",`${h}px`)}):_ds.F(a,"dropdown-full","",b)}f=d.getBoundingClientRect();b.hasAttribute("dropdown-full")?_ds.Hk(d,"left",`-${f.left}px`):(e=Math.min(f.left,f.left+f.width-e.width),
0<e&&_ds.Hk(d,"left",`-${e}px`));c?(c.removeAttribute("dropdown--open"),j_(a,c),c=c.querySelector(".devsite-tabs-dropdown"),null===c||void 0===c?void 0:c.removeAttribute("dropdown-transition"),_ds.F(a,"hidden","",c)):(_ds.F(a,"dropdown-transition","",d),_ds.Bk(a.j,d,_ds.kf,()=>d.removeAttribute("dropdown-transition")));window.requestAnimationFrame(()=>{_ds.F(a,"dropdown--open","");_ds.F(a,"dropdown--open","",b);j_(a,b)})}else c&&(c.removeAttribute("dropdown--open"),j_(a,c))}}else c_(a)},j_=function(a,
b){_ds.F(a,"aria-expanded",`${b.hasAttribute("dropdown--open")}`,b.querySelector(".devsite-tabs-dropdown-toggle"))},b_=function(a){_ds.F(a,"hidden","",a.D);a.removeAttribute("overflow-menu--open")},WZ=async function(a){return(await _ds.A()).isTouchEnabled()||!a.hasAttribute("generated-tab-menu")?!1:!0},XZ=function(a){var b=a.querySelector(".dropdown-tabbed-menu-button-target");if(!a.querySelector(".dropdown-tabbed-menu-button")&&b){var c=a.querySelector("a");c&&(c=c.textContent,b=b.querySelector(".devsite-nav-item a"),
a=a.querySelector(".dropdown-tabbed-menu"),b&&(c=_ds.R(UZ,{yh:(c||"").toLowerCase().trim(),href:b.getAttribute("href")||"",text:b.textContent||""}),null===a||void 0===a?void 0:a.appendChild(c)))}},YZ=function(a,b,c){var d=Array.from(b.querySelectorAll(".devsite-tabs-dropdown-column"));b=Array.from(b.querySelectorAll(".dropdown-tabbed-menu a"));b.forEach(e=>e.removeAttribute("active"));d.forEach(e=>_ds.F(a,"hidden","",e));b=b.find(e=>e.getAttribute("column-id")===c);d=d.find(e=>e.getAttribute("column-id")===
c);b&&d&&(_ds.F(a,"active","",b),d.removeAttribute("hidden"))},k_=class extends _ds.H{constructor(){super();this.eventHandler=new _ds.J;this.j=new _ds.J;this.G=new _ds.xk(()=>{i_(this)},20);this.J=null;this.H=!1;this.F=0;this.D=this.h=null;this.K=0;this.Fb=[];this.v=null;_ds.Tg(this,this.o`active`,this.o`aria-expanded`,this.o`aria-selected`,this.o`collapsed`,this.o`column-id`,this.o`connected`,this.o`dropdown`,this.o`dropdown-full`,this.o`dropdown--open`,this.o`dropdown-transition`,this.o`hidden`,
this.o`no-overflow`,this.o`overflow-menu--open`,this.o`overflow-tab`,this.o`render-hidden`,this.o`scrollbars`)}disconnectedCallback(){_ds.K(this.eventHandler);_ds.K(this.j)}connectedCallback(){this.H||(VZ(this),this.H=!0);_ds.F(this,"connected","");var a;this.hasAttribute("no-overflow")||(_ds.F(this,"collapsed","",this.h),this.K=$Z(this,this.h),null===(a=this.h)||void 0===a?void 0:a.removeAttribute("collapsed"),h_(this),i_(this));ZZ(this)}C(a){for(;a&&a!==this;){if("TAB"===a.tagName.toUpperCase())return a;
a=a.parentElement}return null}L(a){const b=this.J||this.querySelector("[active]");b&&(b.removeAttribute("active"),_ds.F(this,"aria-selected","false",b));_ds.F(this,"active","",a);_ds.F(this,"aria-selected","true",a);this.J=a}};k_.prototype.connectedCallback=k_.prototype.connectedCallback;k_.prototype.disconnectedCallback=k_.prototype.disconnectedCallback;try{window.customElements.define("devsite-tabs",k_)}catch(a){console.warn("devsite.app.customElement.DevsiteTabs",a)};})(_ds_www);


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
  captures_list: 64.073
  exclusion.robots: 0.16
  exclusion.robots.policy: 0.144
  RedisCDXSource: 0.882
  esindex: 0.01
  LoadShardBlock: 34.633 (3)
  PetaboxLoader3.datanode: 60.724 (5)
  load_resource: 58.841 (2)
  PetaboxLoader3.resolve: 25.995
*/