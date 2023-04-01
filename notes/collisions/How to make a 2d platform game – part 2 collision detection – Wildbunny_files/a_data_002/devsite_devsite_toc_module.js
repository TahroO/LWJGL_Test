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

(function(_ds){var window=this;var R_=function(a){var b=a.Lo,c=a.Kb,d=a.Tl;a=a.Tm;let e;e='<ul class="devsite-nav-list"><li class="devsite-nav-item devsite-nav-heading devsite-toc-toggle" role="heading" aria-level="2"><span class="devsite-nav-title"><span class="devsite-nav-text">On this page</span></span>';c&&(e=e+'<button type="button" title="'+_ds.UC("Expand/collapse contents"),e+='" class="devsite-nav-show-all button-transparent material-icons"></button>');e+="</li>";const f=b.length;for(let h=0;h<f;h++){var g=b[h];e+='<li class="devsite-nav-item"'+
(c&&g.index<a?" visible":"")+'><a href="#'+_ds.X(g.id)+'" class="devsite-nav-title gc-analytics-event" data-category="Site-Wide Custom Events" data-action="click" data-label="'+(c?"Embedded nav":"Right nav")+'" data-value="'+_ds.X(h)+'" track-type="navigation" track-name="'+(c?"embeddedNav":"rightNav")+'" track-metadata-position="'+_ds.X(h)+'" track-metadata-link-destination="#'+_ds.X(g.id)+'"><span class="devsite-nav-text" tooltip>'+_ds.W(g.text)+"</span></a>";if(_ds.JC(g.children).length){e+='<ul class="devsite-nav-list">';
g=g.children;const k=g.length;for(let l=0;l<k;l++){const m=g[l];e+='<li class="devsite-nav-item"'+(c&&m.index<a?" visible":"")+'><a href="#'+_ds.X(m.id)+'" class="devsite-nav-title gc-analytics-event" data-category="Site-Wide Custom Events" data-action="click" data-label="'+(c?"Embedded nav":"Right nav")+'" data-value="'+_ds.X(h)+"."+_ds.X(l)+'" track-type="navigation" track-name="'+(c?"embeddedNav":"rightNav")+'" track-metadata-position="'+_ds.X(h)+"."+_ds.X(l)+'" track-metadata-link-destination="#'+
_ds.X(m.id)+'"><span class="devsite-nav-text" tooltip>'+_ds.W(m.text)+"</span></a></li>"}e+="</ul>"}e+="</li>"}d&&(e=c?e+'<li class="devsite-nav-item devsite-apix-link"><a href="#try-it" class="devsite-nav-title"><span class="devsite-nav-text" tooltip>Try it</span></a></li>':e+'<button type="button" class="devsite-show-apix button-primary">Try it!</button>');c&&(e=e+'<li class="devsite-toc-toggle"><button type="button" class="button-flat devsite-nav-more-items material-icons" track-type="navigation" track-name="embeddedNavExpand" title="'+
_ds.UC("Expand/collapse contents"),e+='"></button></li>');return(0,_ds.V)(e+"</ul>")};var T_=function(a){if(!a.hasAttribute("disabled")){var b=document.querySelector("devsite-content .devsite-article-body");b?(a.Kb?a.classList.add("devsite-toc-embedded"):a.classList.add("devsite-toc"),S_(a,b),a.H=!0):a.ob()}},V_=async function(a){await U_(a);if(a.h){var b=`#${a.h.id}`,c=encodeURI(b);b=a.F.get(b)||a.F.get(c);a.v!==b&&(a.v&&a.v.classList.remove("devsite-nav-active"),b&&(b.classList.add("devsite-nav-active"),a.v=b))}},W_=function(a){a.Kb||a.eventHandler.listen(document.body,"devsite-content-updated devsite-element-hidden devsite-element-visible devsite-page-loaded devsite-sticky-resize devsite-sticky-scroll".split(" "),
()=>{a.K.ua()});a.eventHandler.listen(document.body,"devsite-content-updated",()=>{T_(a)})},X_=async function(a){if("IntersectionObserver"in _ds.Oh()){a.C&&a.C.disconnect();var b=document.querySelector("devsite-header");let c=152;b&&(await window.customElements.whenDefined("devsite-header"),(b=Number(b.getAttribute("top-row--height"))+Number(b.getAttribute("bottom-row--height")))&&(c=b));a.C=new IntersectionObserver(d=>{for(const e of d)e.isIntersecting?a.D.add(e.target):a.D.delete(e.target);a.K.ua()},
{rootMargin:`${c}px 0px 0px 0px`,threshold:[0,1]})}a.J.h()},U_=async function(a){let b=0;var c=document.querySelector("devsite-header");c&&(await window.customElements.whenDefined("devsite-header"),b=c.C());c=a.j.findIndex(e=>a.D.has(e)&&e.getBoundingClientRect().top>=b);const d=a.j[c];if(d){const e=await Y_();d.getBoundingClientRect().top-b>e&&0<c?a.h=a.j[c-1]:a.h=d}else a.h&&a.h.getBoundingClientRect().top>window.innerHeight&&(c=a.j.indexOf(a.h),0<c&&(a.h=a.j[c-1]))},S_=function(a,b){const c=[];
let d=!1,e="";switch(a.getAttribute("depth")){case "1":e="h2:not(.hide-from-toc):not(#contents):not(#table-of-contents)";break;default:e="h2:not(.hide-from-toc):not(#contents):not(#table-of-contents), h3:not(.hide-from-toc):not(#contents):not(#table-of-contents)"}a.j=[...b.querySelectorAll(e)].filter(f=>f.id&&f.dataset.text).filter(f=>Z_(f));for(const [f,g]of a.j.entries())b=g,b={id:b.id,level:b.tagName.toLowerCase(),text:b.dataset.text,children:[],index:f},"h2"===b.level?(c.push(b),d=!0):d?c[c.length-
1].children.push(b):c.push(b);_ds.db(a.G,c,a.L.bind(a))&&a.H||(c.length?($_(a,c),a.show(),a.Kb||a0(a)):a.ob(),a.G=c)},Z_=function(a){return _ds.xj.find(b=>!!_ds.li(a,null,b,6))||_ds.li(a,"devsite-selector",null,6)||_ds.li(a,null,"devsite-dialog",3)?!1:!0},$_=function(a,b){const c=_ds.R(R_,{Lo:b,Kb:a.Kb,Tl:!!document.body.querySelector("devsite-apix, .devsite-apix"),Tm:8>b.length?8:5});b=c.querySelectorAll("a.devsite-nav-title");for(const d of b){b=d;const e=b.hash,f=encodeURI(b.hash);a.F.set(e,b);
a.F.set(f,b)}_ds.Th(a);a.Kb&&_ds.F(a,"hidden","",c);a.appendChild(c);if(a.Kb){if(8<a.getElementsByClassName("devsite-nav-item").length){for(const d of a.querySelectorAll(".devsite-nav-show-all, .devsite-nav-more-items"))a.eventHandler.listen(d,"click",()=>{a.hasAttribute("expanded")?a.removeAttribute("expanded"):_ds.F(a,"expanded","")});_ds.F(a,"expandable","")}else a.removeAttribute("expandable");setTimeout(()=>{c.removeAttribute("hidden")},0)}},a0=async function(a){await a.J.promise;if(a.C){a.C.disconnect();
a.D.clear();a.v&&a.v.classList.remove("devsite-nav-active");a.v=null;for(const b of a.j)a.C.observe(b)}},Y_=async function(){let a=0,b=0;const c=document.querySelector("devsite-header");c&&(await window.customElements.whenDefined("devsite-header"),a=c.C(),b=c.J());return Math.max(b-a,Math.floor((window.innerHeight-a)/5))},b0=class extends _ds.H{constructor(){super();this.eventHandler=new _ds.J;this.J=new _ds.Dk;this.D=new Set;this.F=new Map;this.R=new _ds.xk(()=>void T_(this),16);this.K=new _ds.xk(()=>
void V_(this),33);this.h=this.v=null;this.j=[];this.H=!1;this.C=null;this.Kb=!1;this.G=[];_ds.Tg(this,(0,_ds.v)`disabled`,(0,_ds.v)`has-sidebar`,(0,_ds.v)`hidden`,(0,_ds.v)`expandable`,(0,_ds.v)`expanded`,(0,_ds.v)`visible`)}static get observedAttributes(){return["max-height","offset"]}connectedCallback(){this.Kb=this.hasAttribute("devsite-toc-embedded");T_(this);W_(this)}disconnectedCallback(){this.ob();this.H=!1;_ds.K(this.eventHandler)}$e(a){a=a&&"false"===a.toLowerCase();this.G=[];_ds.Th(this);
a?(_ds.F(this,"disabled",""),this.ob()):(this.removeAttribute("disabled"),this.show(),this.R.ua())}ob(){_ds.Th(this);this.dispatchEvent(new CustomEvent("devsite-element-hidden",{bubbles:!0}));this.removeAttribute("visible");_ds.F(this,"hidden","");if(!this.Kb){const a=document.querySelector(".devsite-main-content");a&&a.removeAttribute("has-sidebar")}}show(){this.dispatchEvent(new CustomEvent("devsite-element-visible",{bubbles:!0}));this.removeAttribute("hidden");_ds.F(this,"visible","");if(!this.Kb){const a=
document.querySelector(".devsite-main-content");a&&_ds.F(this,"has-sidebar","",a);X_(this)}}L(a,b){let c=!0;if(a.children.length||b.children.length)c=_ds.db(a.children,b.children,this.L.bind(this));return c&&a.id===b.id&&a.text===b.text}};b0.prototype.renderUpdatedContent=b0.prototype.$e;b0.prototype.disconnectedCallback=b0.prototype.disconnectedCallback;b0.prototype.connectedCallback=b0.prototype.connectedCallback;try{window.customElements.define("devsite-toc",b0)}catch(a){console.warn("Unrecognized DevSite custom element - DevsiteToc",a)};})(_ds_www);


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
  captures_list: 146.998
  exclusion.robots: 0.092
  exclusion.robots.policy: 0.081
  cdx.remote: 0.066
  esindex: 0.009
  LoadShardBlock: 120.93 (3)
  PetaboxLoader3.datanode: 174.937 (5)
  load_resource: 873.26 (2)
  PetaboxLoader3.resolve: 814.296 (2)
*/