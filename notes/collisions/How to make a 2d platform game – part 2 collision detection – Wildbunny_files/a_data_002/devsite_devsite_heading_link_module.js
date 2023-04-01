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

(function(_ds){var window=this;var rT=function(a){return(0,_ds.V)('<span class="devsite-heading" role="heading" aria-level="'+_ds.X(a.level)+'"></span>')},sT=function(a){var b=a.id;a=a.label;return(0,_ds.V)('<button type="button" class="devsite-heading-link button-flat material-icons" aria-label="'+_ds.X(a)+'" data-title="'+_ds.X(a)+'" data-id="'+_ds.X(b)+'"></button>')};var tT=async function(a){a.j=Array.from(document.querySelectorAll("h1.add-link[id],h2:not(.no-link)[id],h3:not(.no-link)[id],h4:not(.no-link)[id],h5:not(.no-link)[id],h6:not(.no-link)[id]"));const b=await _ds.A();for(const c of a.j)b.registerIntersectionForElement(c,()=>{var d=c;if(!d.querySelector(".devsite-heading-link")&&(d.classList.contains("add-link")||!("full"===document.body.getAttribute("layout")||_ds.li(d,"devsite-dialog",null,3)||_ds.li(d,"devsite-selector",null,6)||_ds.li(d,"table",null,
4)))){var e=d.textContent||d.dataset.text;if(e&&d.id){const f="Copy link to this section: "+e,g=_ds.R(rT,{level:d.tagName[1]});for(const h of Array.from(d.childNodes))g.append(h);d.append(g);e=_ds.R(sT,{id:d.id,label:e?f:"Copy link to this section"});d.appendChild(e);d.setAttribute("role","presentation");d.removeAttribute("tabindex")}}b.unregisterIntersectionForElement(c)})},vT=function(a){a.eventHandler.listen(document.body,"devsite-page-changed",()=>{tT(a)});a.eventHandler.listen(document,"click",
b=>{b=b.target;if(b.classList.contains("devsite-heading-link")){var c=_ds.li(b,"devsite-expandable",null,3),d=c?c.id:b.dataset.id;d&&(c=_ds.I(),c.hash=d,d=document.createElement("div"),d.innerText=c.href,_ds.nq(a,[d]),uT(a,b))}})},uT=async function(a,b){if(a.h){const c=b.getAttribute("aria-label");b.setAttribute("aria-label","Link to this section was copied to the clipboard");_ds.Bk(a.eventHandler,a.h,_ds.kf,()=>{_ds.Bk(a.eventHandler,a.h,_ds.kf,()=>{b.setAttribute("aria-label",c)})})}},wT=class extends _ds.H{constructor(){super();
this.eventHandler=new _ds.J;this.h=null;this.j=[]}async connectedCallback(){await tT(this);vT(this);this.h=document.querySelector("devsite-snackbar")}async disconnectedCallback(){const a=await _ds.A();for(const b of this.j)a.unregisterIntersectionForElement(b);_ds.K(this.eventHandler)}};try{window.customElements.define("devsite-heading-link",wT)}catch(a){console.warn("Unrecognized DevSite custom element - DevsiteHeadingLink",a)};})(_ds_www);


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
  captures_list: 157.908
  exclusion.robots: 0.071
  exclusion.robots.policy: 0.06
  RedisCDXSource: 0.677
  esindex: 0.008
  LoadShardBlock: 136.483 (3)
  PetaboxLoader3.datanode: 185.437 (5)
  load_resource: 141.963 (2)
  PetaboxLoader3.resolve: 71.226 (2)
*/