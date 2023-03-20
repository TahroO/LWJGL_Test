#version 330

in vec2 outTextCoord;

out vec4 fragColor;

uniform sampler2D txtSampler;
uniform vec2 spriteSheetSize;
uniform float spriteIndex;
uniform vec2 spriteOrientation;

vec2 flipTexture = vec2(spriteOrientation.x, spriteOrientation.y);

void main()
{
    float txtDeltaY = floor(spriteIndex / spriteSheetSize.x);
    float txtDeltaX = spriteIndex - txtDeltaY * spriteSheetSize.x;
    if (spriteOrientation.y < 0) {
        txtDeltaY = spriteSheetSize.y - 1 - txtDeltaY;
    }
    if (spriteOrientation.x < 0) {
        txtDeltaX = spriteSheetSize.x - 1 - txtDeltaX;
    }
    vec2 txtDelta = vec2(txtDeltaX / spriteSheetSize.x, txtDeltaY / spriteSheetSize.y);
    fragColor = texture2D(txtSampler, (outTextCoord + txtDelta) * flipTexture);
}

