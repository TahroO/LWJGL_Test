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

(function(_ds){var window=this;var JS=function(a,b,c){return a.h.then(function(d){var e=d[b];if(!e)throw Error("Method not found: "+b);return e.apply(d,c)})},KS=class{constructor(a){this.h=a;a.then((0,_ds.sd)(function(){},this),()=>{},this)}},MS=function(a,b,c){for(var d=Array(arguments.length-2),e=2;e<arguments.length;e++)d[e-2]=arguments[e];e=LS(a,b).then(function(f){return f.apply(null,d)});return new KS(e)},NS={},LS=function(a,b){var c=NS[b];if(c)return c;c=(c=_ds.kd(b))?_ds.fk(c):(new _ds.bk(function(d,e){var f=(new _ds.Eh(document)).createElement("SCRIPT");
f.async=!0;_ds.Nc(f,_ds.eg(_ds.pc(a)));f.onload=f.onreadystatechange=function(){f.readyState&&"loaded"!=f.readyState&&"complete"!=f.readyState||d()};f.onerror=e;(document.head||document.getElementsByTagName("head")[0]).appendChild(f)})).then(function(){var d=_ds.kd(b);if(!d)throw Error("Failed to load "+b+" from "+a);return d});return NS[b]=c};var OS=class{constructor(a){this.h=a}v(a){_ds.jk(JS(this.h,"requestSurvey",arguments),()=>{},this)}j(a){_ds.jk(JS(this.h,"presentSurvey",arguments),()=>{},this)}o(a){_ds.jk(JS(this.h,"dismissSurvey",arguments),()=>{},this)}},PS=new _ds.oc(_ds.Xf,"https://web.archive.org/web/20220227113400/https://www.gstatic.com/feedback/js/help/prod/service/lazy.min.js");_ds.jk(LS(PS,"help.service.Lazy.create"),()=>{});var QS=function(){return"devsite-hats-survey"},US=function(){var a;return RS?(null===(a=SS)||void 0===a?void 0:a.o({surveyMetadata:{sessionId:RS}}),TS.promise):Promise.resolve()},VS=async function(a){var b=await _ds.A();let c="AIzaSyArC61vXsxgHizCNzGEDzdTWWhmiZsP2V4";b.hasFlagAccess(186)&&(c=_ds.B(b.getConfig(),18));var d=a.getAttribute("listnr-id");d?(b={locale:b.getLocale()||"en",apiKey:c},d=MS(PS,"help.service.Lazy.create",d,{apiKey:b.apiKey||b.apiKey,environment:b.environment||b.environment,helpCenterPath:b.Zt||
b.helpCenterPath,locale:b.locale||b.locale||"en".replace(/-/g,"_"),nonce:b.nonce||b.nonce,productData:b.productData||b.productData,receiverUri:b.vu||b.receiverUri,renderApiUri:b.wu||b.renderApiUri,theme:b.theme||b.theme,window:b.window||b.window}),SS=new OS(d),a.h=SS):console.warn('<devsite-hats-survey> missing attribute "listnr-id"')},YS=function(a,b){var c;null===(c=a.h)||void 0===c?void 0:c.j({productData:{customData:{pageUrl:_ds.I().toString()}},surveyData:b,colorScheme:1,authuser:0,customZIndex:1E4,
listener:{surveyPrompted:d=>{RS=d.sessionId||null;TS=new _ds.Dk;WS=TS.h},surveyClosed:()=>{RS=XS=null;WS()}}})},aT=class extends _ds.H{constructor(a){super();this.h=null;a&&(this.h=SS=a)}async connectedCallback(){XS=this;const a=this.getAttribute("hats-id");a&&a!==ZS&&(await US(),this.h||await VS(this),ZS=a,await this.lj(a))}disconnectedCallback(){XS=null;_ds.Bk($S,document.body,"devsite-page-changed",()=>{XS||(US(),ZS=null)})}async lj(a){var b;await _ds.A();null===(b=this.h)||void 0===b?void 0:b.v({triggerId:a,
callback:c=>{c.surveyData&&YS(this,c.surveyData)},authuser:0,enableTestingMode:!1})}};aT.prototype.renderSurvey=aT.prototype.lj;aT.prototype.disconnectedCallback=aT.prototype.disconnectedCallback;aT.prototype.connectedCallback=aT.prototype.connectedCallback;aT.closeCurrentSurvey=US;aT.getTagName=QS;var ZS=null,RS=null,XS=null,TS=new _ds.Dk,WS=TS.h,$S=new _ds.J,SS=void 0;try{window.customElements.define(QS(),aT)}catch(a){console.warn("devsite.app.customElement.DevsiteHatsSurvey",a)};})(_ds_www);


}
/*
     FILE ARCHIVED ON 11:34:00 Feb 27, 2022 AND RETRIEVED FROM THE
     INTERNET ARCHIVE ON 10:46:10 Mar 28, 2023.
     JAVASCRIPT APPENDED BY WAYBACK MACHINE, COPYRIGHT INTERNET ARCHIVE.

     ALL OTHER CONTENT MAY ALSO BE PROTECTED BY COPYRIGHT (17 U.S.C.
     SECTION 108(a)(3)).
*/
/*
playback timings (ms):
  captures_list: 122.552
  exclusion.robots: 0.081
  exclusion.robots.policy: 0.071
  cdx.remote: 0.063
  esindex: 0.01
  LoadShardBlock: 90.991 (3)
  PetaboxLoader3.datanode: 116.262 (4)
  load_resource: 292.469
  PetaboxLoader3.resolve: 210.244
*/