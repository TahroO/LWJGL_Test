#version 330

in vec2 outTextCoord;

out vec4 fragColor;

uniform float time;
uniform sampler2D txtSampler;
uniform ivec2 txtSize;
uniform int txtIndex;
uniform int txtFrames;
uniform float txtFps;

void main()
{
    int deltaTxtIndex = txtIndex + int(mod(floor(time * txtFps), txtFrames));
    int indexY = txtIndex + int(deltaTxtIndex / float(txtSize.x));
    int indexX = deltaTxtIndex - int(indexY * float(txtSize.x));
    float deltaX = indexX / float(txtSize.x);
    float deltaY = indexY / float(txtSize.y);
    fragColor = texture2D(txtSampler, vec2(outTextCoord.x + deltaX, outTextCoord.y + deltaY));
}
