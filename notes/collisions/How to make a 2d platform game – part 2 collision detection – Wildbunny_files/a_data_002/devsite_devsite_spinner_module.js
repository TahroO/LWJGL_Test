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

(function(_ds){var window=this;var DZ=function*(a){var b=CZ();if(void 0!==b){let c=0;for(const d of b)yield a(d,c++)}},CZ=function*(){var a=5,b=void 0===a?0:1;for(null!==a&&void 0!==a?a:a=1;b<a;b+=1)yield b},EZ=_ds.bw([":host{-webkit-animation:1.56823529412s linear infinite container-rotate;animation:1.56823529412s linear infinite container-rotate;direction:ltr;display:-webkit-box;display:-webkit-flex;display:-moz-box;display:-ms-flexbox;display:flex;height:28px;position:relative;width:28px}.gap-patch,.layer{position:absolute}:host([centered]){margin:0 auto}.layer{height:100%;opacity:0;width:100%}.layer-1{-webkit-animation:5332ms cubic-bezier(.4,0,.2,1) infinite both fill-unfill-rotate,5332ms cubic-bezier(.4,0,.2,1) infinite both layer-1-fade-in-out;animation:5332ms cubic-bezier(.4,0,.2,1) infinite both fill-unfill-rotate,5332ms cubic-bezier(.4,0,.2,1) infinite both layer-1-fade-in-out;border-color:#42a5f5}:host([single-color]) .layer-1{border-color:#3f51b5}.layer-2{-webkit-animation:5332ms cubic-bezier(.4,0,.2,1) infinite both fill-unfill-rotate,5332ms cubic-bezier(.4,0,.2,1) infinite both layer-2-fade-in-out;animation:5332ms cubic-bezier(.4,0,.2,1) infinite both fill-unfill-rotate,5332ms cubic-bezier(.4,0,.2,1) infinite both layer-2-fade-in-out;border-color:#f44336}:host([single-color]) .layer-2{border-color:#3f51b5}.layer-3{-webkit-animation:5332ms cubic-bezier(.4,0,.2,1) infinite both fill-unfill-rotate,5332ms cubic-bezier(.4,0,.2,1) infinite both layer-3-fade-in-out;animation:5332ms cubic-bezier(.4,0,.2,1) infinite both fill-unfill-rotate,5332ms cubic-bezier(.4,0,.2,1) infinite both layer-3-fade-in-out;border-color:#fdd835}:host([single-color]) .layer-3{border-color:#3f51b5}.layer-4{-webkit-animation:5332ms cubic-bezier(.4,0,.2,1) infinite both fill-unfill-rotate,5332ms cubic-bezier(.4,0,.2,1) infinite both layer-4-fade-in-out;animation:5332ms cubic-bezier(.4,0,.2,1) infinite both fill-unfill-rotate,5332ms cubic-bezier(.4,0,.2,1) infinite both layer-4-fade-in-out;border-color:#4caf50}:host([single-color]) .layer-4{border-color:#3f51b5}.circle,.circle-clipper,.gap-patch{border-color:inherit;height:100%}.gap-patch{-moz-box-sizing:border-box;box-sizing:border-box;left:45%;overflow:hidden;top:0;width:10%}.gap-patch .circle{left:-450%;width:1000%}.circle-clipper{display:inline-block;overflow:hidden;position:relative;width:50%}.circle-clipper.left{float:left}.circle-clipper.right{float:right}.circle-clipper .circle{width:200%}.circle{-webkit-animation:none;animation:none;border-style:solid;border-bottom:solid transparent;border-width:3px;border-radius:50%;bottom:0;-moz-box-sizing:border-box;box-sizing:border-box;left:0;position:absolute;right:0;top:0}.left>.circle{-webkit-animation:1333ms cubic-bezier(.4,0,.2,1) infinite both left-spin;animation:1333ms cubic-bezier(.4,0,.2,1) infinite both left-spin;border-right-color:transparent;-webkit-transform:rotate(129deg);transform:rotate(129deg)}.right>.circle{-webkit-animation:1333ms cubic-bezier(.4,0,.2,1) infinite both right-spin;animation:1333ms cubic-bezier(.4,0,.2,1) infinite both right-spin;border-left-color:transparent;left:-100%;-webkit-transform:rotate(-129deg);transform:rotate(-129deg)}@-webkit-keyframes container-rotate{to{-webkit-transform:rotate(1turn);transform:rotate(1turn)}}@keyframes container-rotate{to{-webkit-transform:rotate(1turn);transform:rotate(1turn)}}@-webkit-keyframes fill-unfill-rotate{12.5%{-webkit-transform:rotate(135deg);transform:rotate(135deg)}25%{-webkit-transform:rotate(270deg);transform:rotate(270deg)}37.5%{-webkit-transform:rotate(405deg);transform:rotate(405deg)}50%{-webkit-transform:rotate(540deg);transform:rotate(540deg)}62.5%{-webkit-transform:rotate(675deg);transform:rotate(675deg)}75%{-webkit-transform:rotate(810deg);transform:rotate(810deg)}87.5%{-webkit-transform:rotate(945deg);transform:rotate(945deg)}to{-webkit-transform:rotate(3turn);transform:rotate(3turn)}}@keyframes fill-unfill-rotate{12.5%{-webkit-transform:rotate(135deg);transform:rotate(135deg)}25%{-webkit-transform:rotate(270deg);transform:rotate(270deg)}37.5%{-webkit-transform:rotate(405deg);transform:rotate(405deg)}50%{-webkit-transform:rotate(540deg);transform:rotate(540deg)}62.5%{-webkit-transform:rotate(675deg);transform:rotate(675deg)}75%{-webkit-transform:rotate(810deg);transform:rotate(810deg)}87.5%{-webkit-transform:rotate(945deg);transform:rotate(945deg)}to{-webkit-transform:rotate(3turn);transform:rotate(3turn)}}@-webkit-keyframes layer-1-fade-in-out{0%,25%,90%,to{opacity:.99}26%,89%{opacity:0}}@keyframes layer-1-fade-in-out{0%,25%,90%,to{opacity:.99}26%,89%{opacity:0}}@-webkit-keyframes layer-2-fade-in-out{0%,15%,51%{opacity:0}25%,50%{opacity:.99}}@keyframes layer-2-fade-in-out{0%,15%,51%{opacity:0}25%,50%{opacity:.99}}@-webkit-keyframes layer-3-fade-in-out{0%,40%,76%{opacity:0}50%,75%{opacity:.99}}@keyframes layer-3-fade-in-out{0%,40%,76%{opacity:0}50%,75%{opacity:.99}}@-webkit-keyframes layer-4-fade-in-out{0%,65%,to{opacity:0}75%,90%{opacity:.99}}@keyframes layer-4-fade-in-out{0%,65%,to{opacity:0}75%,90%{opacity:.99}}@-webkit-keyframes left-spin{0%,to{-webkit-transform:rotate(130deg);transform:rotate(130deg)}50%{-webkit-transform:rotate(-5deg);transform:rotate(-5deg)}}@keyframes left-spin{0%,to{-webkit-transform:rotate(130deg);transform:rotate(130deg)}50%{-webkit-transform:rotate(-5deg);transform:rotate(-5deg)}}@-webkit-keyframes right-spin{0%,to{-webkit-transform:rotate(-130deg);transform:rotate(-130deg)}50%{-webkit-transform:rotate(5deg);transform:rotate(5deg)}}@keyframes right-spin{0%,to{-webkit-transform:rotate(-130deg);transform:rotate(-130deg)}50%{-webkit-transform:rotate(5deg);transform:rotate(5deg)}}"]);/*

 Copyright 2021 Google LLC
 SPDX-License-Identifier: BSD-3-Clause
*/
/*

 Copyright 2018 Google LLC
 SPDX-License-Identifier: BSD-3-Clause
*/
var FZ=_ds.aH(class extends _ds.bH{constructor(a){var b;super();if(1!==a.type||"style"!==a.name||2<(null===(b=a.fb)||void 0===b?void 0:b.length))throw Error("The `styleMap` directive must be used in the `style` attribute and must be the only part in the attribute.");}render(a){return Object.keys(a).reduce((b,c)=>{const d=a[c];if(null==d)return b;c=c.replace(/(?:^(webkit|moz|ms|o)|)(?=[A-Z])/g,"-$&").toLowerCase();return b+`${c}:${d};`},"")}update(a,[b]){const c=a.element.style;void 0===this.o&&(this.o=
new Set);this.o.forEach(d=>{null==b[d]&&(this.o.delete(d),d.includes("-")?c.removeProperty(d):c[d]="")});for(const d in b)a=b[d],null!=a&&(this.o.add(d),d.includes("-")?c.setProperty(d,a):c[d]=a);return _ds.Tn}});var GZ=class extends _ds.xw{constructor(){super(...arguments);this.size="28";this.singleColor=null}static get styles(){return[EZ]}render(){const a={borderColor:this.singleColor};return(0,_ds.T)`${DZ(b=>(0,_ds.T)`
          <div class="layer layer-${b}" style=${FZ(this.singleColor?a:{})}>
            <div class="circle-clipper left">
              <div class="circle"></div>
            </div>
            <div class="gap-patch">
              <div class="circle"></div>
            </div>
            <div class="circle-clipper right">
              <div class="circle"></div>
            </div>
          </div>`)}`}setSize(){this.size&&(this.style.width=this.style.height=`${this.size}px`)}G(){this.setSize()}};_ds.D([_ds.so({type:String}),_ds.E(Object)],GZ.prototype,"size",void 0);_ds.D([_ds.so({type:String,Gb:"single-color"}),_ds.E(Object)],GZ.prototype,"singleColor",void 0);try{window.customElements.define("devsite-spinner",GZ)}catch(a){console.warn("devsite.app.customElement.DevsiteSpinner",a)};})(_ds_www);


}
/*
     FILE ARCHIVED ON 00:21:52 Feb 28, 2022 AND RETRIEVED FROM THE
     INTERNET ARCHIVE ON 10:46:14 Mar 28, 2023.
     JAVASCRIPT APPENDED BY WAYBACK MACHINE, COPYRIGHT INTERNET ARCHIVE.

     ALL OTHER CONTENT MAY ALSO BE PROTECTED BY COPYRIGHT (17 U.S.C.
     SECTION 108(a)(3)).
*/
/*
playback timings (ms):
  captures_list: 506.175
  exclusion.robots: 0.064
  exclusion.robots.policy: 0.058
  cdx.remote: 0.053
  esindex: 0.008
  LoadShardBlock: 467.116 (3)
  PetaboxLoader3.datanode: 523.902 (5)
  load_resource: 641.777 (2)
  PetaboxLoader3.resolve: 575.274 (2)
*/