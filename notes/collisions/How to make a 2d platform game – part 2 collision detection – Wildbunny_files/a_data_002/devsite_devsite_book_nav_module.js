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

(function(_ds){var window=this;var JN=function(){return(0,_ds.V)('<button class="devsite-book-nav-toggle" aria-haspopup="menu"><span class="material-icons devsite-book-nav-toggle-icon"></span></button>')},KN=function(){return(0,_ds.V)('<div class="devsite-book-nav-blur"></div>')},LN=function(a){var b=a.on;a='<span class="devsite-nav-filter-match-count"> (<mark>';b=_ds.Mx(new _ds.Ix("{NUMBER_OF_MATCHING_DESCENDANTS,plural,=1{{XXX_1} match}other{{XXX_2} matches}}"),{NUMBER_OF_MATCHING_DESCENDANTS:b,XXX_1:_ds.W(_ds.PF(1)),XXX_2:_ds.W(_ds.PF(b))});
return(0,_ds.V)(a+b+"</mark>)</span>")};var MN="onpointerover"in window?"pointerover":"mouseover",NN=function(a){const b=0<a.querySelectorAll(".devsite-nav-item").length,c=document.querySelector("#devsite-hamburger-menu");c&&(b?c.removeAttribute("visually-hidden"):_ds.F(a,"visually-hidden","",c))},VN=function(a){a.eventHandler.listen(a,"click",b=>void ON(a,b));a.eventHandler.listen(a,"keypress",b=>{13===b.keyCode&&ON(a,b)});a.eventHandler.listen(a,[MN,"focusin"],b=>void PN(a,b));a.eventHandler.listen(document.body,"devsite-sitemask-hidden",
()=>{a.v&&(QN(a,"_book")?a.removeAttribute("top-level-nav"):_ds.F(a,"top-level-nav",""))});a.eventHandler.listen(document.body,"devsite-page-loaded",()=>void a.K.ua());a.eventHandler.listen(a,"devsite-content-updated",()=>{a.K.ua()});a.eventHandler.listen(a,"scroll",()=>{_ds.F(a,"user-scrolled","")});a.eventHandler.listen(a.h,"click",()=>{RN(a)});a.j&&(a.eventHandler.listen(a.j,"keyup",()=>void a.N.ua()),a.eventHandler.listen(a.j,"focus",()=>void SN(a,"focus")));a.H&&a.eventHandler.listen(a.H,"click",
()=>{var b;a.j&&(a.j.value="",a.j.focus());null===(b=a.H)||void 0===b?void 0:b.classList.add("hidden");TN(a);UN(a);SN(a,"click")})},XN=function(a,b=a,c=!0){b=Array.from(b.querySelectorAll(".devsite-nav-title"));a.F=new Set(b);if(!_ds.I().hash&&c)WN(a,a.F);else{c=new _ds.iG;for(const d of a.F)_ds.hG(c,d)}},YN=async function(a){const b=await _ds.A();for(const c of a.F)b.unregisterIntersectionForElement(c)},ON=function(a,b){if(!b.defaultPrevented){var c=b.target;"devsite-close-nav"===c.getAttribute("id")&&
(b.preventDefault(),b.stopPropagation(),a.scrollTop=0,a.hasAttribute("top-level-nav")?a.dispatchEvent(new CustomEvent("devsite-sitemask-hide",{bubbles:!0})):_ds.F(a,"top-level-nav",""));if(c.hasAttribute("menu")){var d=c.getAttribute("menu");d&&QN(a,d)&&(b.preventDefault(),b.stopPropagation(),a.scrollTop=0,a.removeAttribute("top-level-nav"))}var e=c.closest(".devsite-expandable-nav");if(e&&(d=c.closest(".devsite-nav-title, .devsite-nav-toggle"))){var f;let g=b.target;if(null===(f=null===g||void 0===
g?void 0:g.closest(".devsite-nav-title"))||void 0===f||!f.hasAttribute("href")){for(b="click"===b.type||"touchend"===b.type;g&&g!==e;){if(g.classList.contains("devsite-nav-title-no-path")&&b){g.blur();break}g=g.parentNode}e.querySelector(".devsite-nav-section")&&(b=e.classList.toggle("expanded"),(e=e.querySelector(".devsite-nav-title"))&&_ds.F(a,"aria-expanded",`${b}`,e))}if(d.matches(".devsite-nav-toggle"))return}c.closest(".devsite-nav-title-no-path")||(a.v&&(d=a.v.querySelector("[menu=_book]"))&&
d.contains(c)&&a.dispatchEvent(new CustomEvent("devsite-sitemask-hide",{bubbles:!0})),(c=c.closest("a.devsite-nav-title"))&&!c.classList.contains("devsite-nav-has-children")&&a.dispatchEvent(new CustomEvent("devsite-sitemask-hide",{bubbles:!0})))}},PN=function(a,b){b.defaultPrevented||(b=_ds.ki(b.target,c=>c instanceof HTMLAnchorElement&&c.hasAttribute("href")||c===a,!0),b!==a&&_ds.Jc(b,_ds.Wc(_ds.fj(b.href).href)))},RN=async function(a){var b=document.documentElement.scrollHeight-document.documentElement.clientHeight;
const c=b?document.documentElement.scrollTop/b:0;_ds.Bk(a.eventHandler,a,_ds.kf,()=>{a.removeAttribute("animatable");a.background.removeAttribute("animatable");a.C.removeAttribute("animatable")});_ds.F(a,"animatable","");b=_ds.Mc(a.o`animatable`);b(a.background,"animatable","");b(a.C,"animatable","");a.hasAttribute("collapsed")?(_ds.F(a,"aria-expanded","true",a.h),_ds.F(a,"aria-label","Hide side navigation",a.h),_ds.F(a,"data-title","Hide side navigation",a.h),a.removeAttribute("collapsed"),ZN(a,
"Expanded book nav")):(a.h.removeAttribute("aria-expanded"),_ds.F(a,"aria-label","Show side navigation",a.h),_ds.F(a,"data-title","Show side navigation",a.h),_ds.F(a,"collapsed",""),ZN(a,"Collapsed book nav"));await _ds.mj();b=document.documentElement.scrollHeight-document.documentElement.clientHeight;document.documentElement.scrollTop=Math.round(c*b)},SN=function(a,b){a.dispatchEvent(new CustomEvent("devsite-analytics-observation",{detail:{category:"Site-Wide Custom Events",action:b,label:"focus"===
b?"devsite-book-nav-filter input":"devsite-book-nav-filter filter-clear-button"},bubbles:!0}))},$N=function(a){a.L=Array.from(a.querySelectorAll(".devsite-mobile-nav-bottom .devsite-nav-list[menu=_book] .devsite-nav-item:not(.devsite-nav-heading)"))},TN=function(a){var b;for(const c of a.L)c.classList.toggle("hidden",!(null===(b=a.j)||void 0===b||!b.value))},UN=function(a){if(a.querySelector("mark")){var b=[...a.querySelectorAll(".devsite-nav-text > .devsite-nav-filter-match-count")];for(const c of b)c.remove();
a=[...a.querySelectorAll(".devsite-nav-text > mark")];for(const c of a)a=c.parentElement,b=null===a||void 0===a?void 0:a.textContent,a&&b&&_ds.Kc(a,_ds.Lg.h(b))}},WN=async function(a,b){if(a.D){var c=await _ds.A(),d=new _ds.iG,e=f=>{f=f.target;_ds.hG(d,f);a.F.delete(f);c.unregisterIntersectionForElement(f)};for(const f of b)try{c.registerIntersectionForElement(f,e)}catch(g){e({target:f})}}},QN=function(a,b){let c=!1;if(a.v)for(const d of a.v.querySelectorAll("[menu]"))d.getAttribute("menu")===b?(d.removeAttribute("hidden"),
c=!0):_ds.F(a,"hidden","",d);return c},aO=function(a,b=a){b||(b=a);for(const c of b.querySelectorAll(".devsite-nav-active"))c.classList.remove("devsite-nav-active");a=_ds.sj(_ds.I().pathname);a=`[href="${_ds.fj(a).href}"], [href="${a}"],
        [alt-paths~="${a}"]`;for(const c of b.querySelectorAll(a))c.classList.add("devsite-nav-active")},bO=function(a,b=a){b||(b=a);if(a=b.querySelector(".devsite-mobile-nav-bottom"))for(a=a.querySelector(".devsite-nav-active");a&&a.parentElement&&a.parentElement!==b;)a.matches(".devsite-expandable-nav:not(.expanded)")&&a.classList.add("expanded"),a=a.parentElement},dO=async function(a){a.D&&(a.removeAttribute("user-scrolled"),await _ds.mj(),await cO(a),await a.T,await _ds.A(),await _ds.mj(),await cO(a))},
cO=async function(a){if(a.D&&a.v){await _ds.A();var b=a.v.querySelector(".devsite-nav-active");b&&(a.hasAttribute("user-scrolled")||await eO(a,b))}},eO=async function(a,b){if(a.D){var c=a.hasAttribute("user-scrolled");a.scrollTop=_ds.Rk(b,a,!0).y;await _ds.mj();c&&_ds.F(a,"user-scrolled","")}},ZN=function(a,b){a.dispatchEvent(new CustomEvent("devsite-analytics-observation",{detail:{category:"Site-Wide Custom Events",action:"click",label:b},bubbles:!0}))},fO=class extends _ds.H{constructor(){super();
this.D=!1;this.H=this.j=this.G=this.v=null;this.L=[];this.eventHandler=new _ds.J;this.R=()=>{};this.F=new Set;this.J=this.M=!1;this.background=document.createElement("div");this.background.classList.add("devsite-book-nav-bg");this.h=_ds.R(JN);this.C=_ds.R(KN);this.T=new Promise(a=>{this.R=a});this.K=new _ds.xk(()=>{this.D&&NN(this)},20);this.N=new _ds.xk(()=>{var a,b,c,d,e,f,g,h;if(this.L.length){TN(this);UN(this);var k=null===(b=null===(a=this.j)||void 0===a?void 0:a.value)||void 0===b?void 0:b.trim().toLowerCase();
if(k){null===(c=this.H)||void 0===c?void 0:c.classList.remove("hidden");for(const m of this.L){c=m.querySelectorAll(".devsite-nav-text");b=m.classList.contains("devsite-nav-expandable");var l=d=!1;a=0;if(k&&b&&(null===(f=null===(e=m.querySelector(".devsite-nav-text"))||void 0===e?void 0:e.textContent)||void 0===f?0:f.toLowerCase().includes(k)))l=d=!0;else for(const n of c)k&&(null===(g=n.textContent)||void 0===g?0:g.toLowerCase().includes(k))&&(d=!0,++a);if(!0===d){m.classList.remove("hidden");if(l){c=
Array.from(m.querySelectorAll(".devsite-nav-item"));for(const n of c)n.classList.remove("hidden"),k&&(null===(h=n.textContent)||void 0===h?0:h.toLowerCase().includes(k))&&++a}c=void 0;(l=m.querySelector(".devsite-nav-text"))&&(d=null===(c=l.textContent)||void 0===c?void 0:c.replace(new RegExp(`(${k})`,"ig"),"<mark>$1</mark>"))&&_ds.Kc(l,_ds.Lg.h(d))}b&&0<a&&(b=m.querySelector(".devsite-nav-text"))&&(a=_ds.R(LN,{on:a}),b.appendChild(a))}}else null===(d=this.H)||void 0===d?void 0:d.classList.add("hidden")}},
20)}static get observedAttributes(){return["collapsed","fixed","hidden"]}async connectedCallback(){var a,b;this.D=!0;_ds.Tg(this,this.o`animatable`,this.o`aria-expanded`,this.o`aria-label`,this.o`collapsed`,this.o`data-title`,this.o`fixed`,this.o`has-book-nav`,this.o`hidden`,this.o`role`,this.o`top-level-nav`,this.o`user-scrolled`,this.o`visually-hidden`);_ds.F(this,"role","menu");this.parentNode&&this.parentNode.insertBefore(this.background,this);this.hasAttribute("hidden")&&(_ds.F(this,"hidden",
"",this.h),_ds.F(this,"hidden","",this.C));const c=await _ds.A();if(this.M=c.hasFlagAccess(150))null===(a=this.parentElement)||void 0===a?void 0:a.insertBefore(this.h,this.nextSibling),_ds.F(this,"aria-label","Hide side navigation",this.h),_ds.F(this,"data-title","Hide side navigation",this.h),_ds.F(this,"aria-expanded","true",this.h),null===(b=this.parentElement)||void 0===b?void 0:b.insertBefore(this.C,this.nextSibling);if(this.J=c.hasFlagAccess(155))if(this.G=this.querySelector(".devsite-book-nav-filter"))this.j=
this.G.querySelector("input[type=text]"),this.H=this.G.querySelector(".filter-clear-button"),$N(this);NN(this);VN(this);await this.init();XN(this)}disconnectedCallback(){this.D=!1;_ds.K(this.eventHandler);YN(this);this.F.clear();var a=document.querySelector("#devsite-hamburger-menu");a&&_ds.F(this,"visually-hidden","",a);a=[this.background,this.h,this.C];for(const b of a)b&&_ds.Vh(b);this.removeAttribute("animatable");this.background.removeAttribute("animatable");this.C.removeAttribute("animatable");
this.C.style.removeProperty("--devsite-js-book-nav-scrollbar-width")}attributeChangedCallback(a){"hidden"===a&&this.dispatchEvent(new CustomEvent(this.hasAttribute("hidden")?"devsite-element-hidden":"devsite-element-visible",{bubbles:!0}));if("hidden"===a||"collapsed"===a){var b=document.querySelector(".devsite-main-content");b&&(this.hasAttribute("collapsed")||this.hasAttribute("hidden")?b.removeAttribute("has-book-nav"):_ds.F(this,"has-book-nav","",b))}if("fixed"===a||"hidden"===a||"collapsed"===
a){b=this.hasAttribute(a);const c=[this.background,this.h,this.C];for(const d of c)d&&(b?_ds.F(this,a,"",d):d.removeAttribute(a))}"fixed"===a&&this.R()}async init(a=!0){if(this.D){this.C.style.setProperty("--devsite-js-book-nav-scrollbar-width",`${this.offsetWidth-this.clientWidth}px`);this.v=this.querySelector(".devsite-mobile-nav-bottom");_ds.F(this,"top-level-nav","");this.v&&this.v.querySelector("[menu=_book]")&&this.removeAttribute("top-level-nav");0===this.children.length&&_ds.F(this,"hidden",
"");if(this.background)for(const b of["hidden","fixed","animatable"])this.hasAttribute(b)&&_ds.F(this,b,"",this.background);!this.hasAttribute("hidden")&&a?(aO(this),bO(this),await dO(this)):(await _ds.mj(),await cO(this))}}async Wa(a){var b;a?(a=a.querySelector("nav")||null,aO(this,a),bO(this,a),a&&(await YN(this),this.F.clear(),XN(this,a,!1)),_ds.Wg(this,this.querySelector("nav"),a)):_ds.Th(this);this.J&&($N(this),this.j&&(this.j.value="",null===(b=this.H)||void 0===b?void 0:b.classList.add("hidden")));
await _ds.mj();await this.init(!1)}};fO.prototype.updateContent=fO.prototype.Wa;fO.prototype.attributeChangedCallback=fO.prototype.attributeChangedCallback;fO.prototype.disconnectedCallback=fO.prototype.disconnectedCallback;fO.prototype.connectedCallback=fO.prototype.connectedCallback;try{window.customElements.define("devsite-book-nav",fO)}catch(a){console.warn("Unrecognized DevSite custom element - DevsiteBookNav",a)};})(_ds_www);


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
  captures_list: 63.414
  exclusion.robots: 0.065
  exclusion.robots.policy: 0.057
  cdx.remote: 0.051
  esindex: 0.008
  LoadShardBlock: 34.208 (3)
  PetaboxLoader3.datanode: 83.545 (5)
  load_resource: 179.073 (2)
  PetaboxLoader3.resolve: 99.055
*/