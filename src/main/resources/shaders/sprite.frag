#version 330

in vec2 outTextCoord;

out vec4 fragColor;

uniform float time;
uniform sampler2D txtSampler;
uniform vec2 spriteSheetSize;
uniform float spriteIndex;
uniform float spriteAnimationFrame;

void main()
{
    float spriteIndexFrame = spriteIndex + spriteAnimationFrame;
    float txtDeltaY = floor(spriteIndexFrame / spriteSheetSize.x);
    float txtDeltaX = spriteIndexFrame - txtDeltaY * spriteSheetSize.x;
    vec2 txtDelta = vec2(txtDeltaX / spriteSheetSize.x, txtDeltaY / spriteSheetSize.y);
    fragColor = texture2D(txtSampler, outTextCoord + txtDelta);
}

