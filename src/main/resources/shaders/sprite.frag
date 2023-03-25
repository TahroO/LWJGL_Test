#version 330

in vec2 outTxtCoord;

out vec4 fragColor;

uniform sampler2D txtSampler;
uniform ivec2 spriteSheetSize;
uniform int spriteIndex;
uniform vec3 flipSprite;
uniform vec3 transparentColor;

void main()
{
    int txtDeltaY = spriteIndex / spriteSheetSize.x;
    int txtDeltaX = spriteIndex - txtDeltaY * spriteSheetSize.x;
    vec2 txtCoord = outTxtCoord;
    vec2 flipTxt = vec2(flipSprite);

    // Flip diagonally.
    if (flipSprite.z < 0) {
        txtCoord = vec2(outTxtCoord.y, outTxtCoord.x);
        flipTxt = vec2(flipSprite.y, flipSprite.x);
    }

    // Flip horizontally.
    if (flipTxt.x < 0) {
        txtDeltaX = spriteSheetSize.x - 1 - txtDeltaX;
    }

    // Flip vertically.
    if (flipTxt.y < 0) {
        txtDeltaY = spriteSheetSize.y - 1 - txtDeltaY;
    }

    vec2 txtDelta = vec2(float(txtDeltaX) / float(spriteSheetSize.x), float(txtDeltaY) / float(spriteSheetSize.y));
    vec4 txtColor = texture2D(txtSampler, (txtCoord + txtDelta) * flipTxt);
    if (txtColor == vec4(transparentColor, 0.0)) {
        discard;
    } else {
        fragColor = txtColor;
    }
}

