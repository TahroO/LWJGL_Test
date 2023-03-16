#version 330

in vec2 outTextCoord;

out vec4 fragColor;

uniform float time;
uniform sampler2D txtSampler;
uniform vec2 spriteAtlasSize;
uniform float spriteIndex;
uniform float spriteFrames;
uniform float spriteFps;

void main()
{
    float spriteIndexFrame = spriteIndex + mod(floor(time * spriteFps), spriteFrames);
    float txtDeltaY = floor(spriteIndexFrame / spriteAtlasSize.x);
    float txtDeltaX = spriteIndexFrame - txtDeltaY * spriteAtlasSize.x;
    vec2 txtDelta = vec2(txtDeltaX / spriteAtlasSize.x, txtDeltaY / spriteAtlasSize.y);
    fragColor = texture2D(txtSampler, outTextCoord + txtDelta);
}
