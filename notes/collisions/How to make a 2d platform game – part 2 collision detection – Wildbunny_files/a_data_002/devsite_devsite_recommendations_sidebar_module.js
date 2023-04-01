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

(function(_ds){var window=this;var $X=function(a){var b=a.Va,c=a.pg;a='<div class="devsite-recommendations-sidebar-heading" role="heading" aria-level="2"><a href="#recommendations-link" class="devsite-nav-title devsite-recommendations-sidebar-heading-link" data-category="Site-Wide Custom Events" data-label="devsite-recommendation side-nav title" data-action="click" data-tooltip="'+_ds.UC("See content recommendations");a+='"><svg class="devsite-recommendations-sidebar-icon" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" aria-hidden="true"><path d=\'M12.5,8.5L10,3L7.5,8.5L2,11l5.5,2.5L10,19l2.5-5.5L18,11L12.5,8.5z M18,13l-1.25,2.75L14,17l2.75,1.25L18,21l1.25-2.75 L22,17l-2.75-1.25L18,13z\'/></svg><span class="devsite-nav-text devsite-nav-title">'+
_ds.W(c)+'</span></a></div><ul class="devsite-nav-list">';c=b.length;for(let d=0;d<c;d++)a+=ZX(b[d]);return(0,_ds.V)(a+"</ul>")},ZX=function(a){let b="";const c=[a.getTitle(),_ds.B(a,3),_ds.B(a,4)];b+='<li role="option" class="devsite-nav-item"><a href="'+_ds.X(_ds.Y(a.getUrl()+"?"+_ds.B(a,8)))+'" class="devsite-nav-title devsite-recommendations-sidebar-title" data-category="Site-Wide Custom Events" data-label="devsite-recommendation side-nav link" data-action="click"><span class="devsite-nav-text" tooltip="">'+
_ds.W(c.filter(d=>0<(""+_ds.JC(d)).length)[0])+'</span></a><div class="significatio-card-meta">Updated <span class="significatio-date" date="'+_ds.X(_ds.Ob(a,_ds.jC,7).getSeconds())+'"></span></div></li>';return(0,_ds.V)(b)};var aY=function(a){a.eventHandler.listen(a,"click",b=>{b.target.classList.contains("devsite-nav-title")&&(b=b.target,a.j&&a.j.classList.remove("devsite-nav-active"),b.classList.add("devsite-nav-active"),a.j=b)});a.eventHandler.listen(document,"devsite-on-recommendations",b=>{b=b.X;if(null===b||void 0===b?0:b.detail)if(b=b.detail,3===_ds.Ce(b,5,0)){a.render(b);a.h.h();if(b=null===b||void 0===b?void 0:_ds.IJ(b)){for(const c of b)if(b=_ds.Ob(c,_ds.Aq,10))b={targetPage:c.getUrl(),targetRank:_ds.Me(b,
2),targetType:_ds.Ce(b,3,0),targetIdenticalDescriptions:_ds.Me(b,4),targetTitleWords:_ds.Me(b,5),targetDescriptionWords:_ds.Me(b,6),experiment:_ds.B(b,7)},b={category:"Site-Wide Custom Events",action:"recommended-right-nav",label:c.getUrl(),additionalParams:{recommendations:b}},a.dispatchEvent(new CustomEvent("devsite-analytics-observation",{detail:b,bubbles:!0}));a.v.h()}else a.v.o("empty");a.classList.add("recommendations-rendered")}else a.h.h()});a.eventHandler.listen(document.body,"devsite-recommendations-disconnected",
()=>{_ds.Th(a);a.classList.remove("recommendations-rendered")})},bY=class extends _ds.H{constructor(a){super();this.timeZone=a;this.eventHandler=new _ds.J(this);this.h=new _ds.Dk;this.loaded=this.h.promise;this.v=new _ds.Dk;this.j=null}connectedCallback(){aY(this)}disconnectedCallback(){_ds.K(this.eventHandler);this.h.o("Disconnected")}render(a){if(this.isConnected){_ds.Q(this,$X,{Va:_ds.IJ(a),pg:_ds.B(a,6)});a=Array.from(this.querySelectorAll(".significatio-date"));for(const b of a){a=b.getAttribute("date");
try{b.textContent=(new Date(1E3*Number(a))).toLocaleDateString("default",{month:"short",year:"numeric",day:"numeric",timeZone:this.timeZone})}catch(c){}}}}};try{window.customElements.define("devsite-recommendations-sidebar",bY)}catch(a){console.warn("Unrecognized DevSite custom element - DevsiteRecommendationsSidebar",a)};})(_ds_www);


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
  captures_list: 70.126
  exclusion.robots: 0.069
  exclusion.robots.policy: 0.058
  cdx.remote: 0.058
  esindex: 0.009
  LoadShardBlock: 37.184 (3)
  PetaboxLoader3.datanode: 106.621 (5)
  load_resource: 153.342 (2)
  PetaboxLoader3.resolve: 76.92 (2)
*/