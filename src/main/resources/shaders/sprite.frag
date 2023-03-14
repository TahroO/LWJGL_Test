#version 330

in vec2 outTextCoord;

out vec4 fragColor;

uniform float time;
uniform sampler2D txtSampler;
uniform vec2 txtSize;
uniform float txtIndex;
uniform float txtFrames;
uniform float txtFps;

void main()
{
    float txtIndexDelta = txtIndex + floor(mod(time * txtFps, txtFrames));
    float txtDeltaY = floor(txtIndex + txtIndexDelta / txtSize.x);
    float txtDeltaX = floor(txtIndexDelta - txtDeltaY * txtSize.x);
    vec2 txtDelta = vec2(txtDeltaX / txtSize.x, txtDeltaY / txtSize.y);
    fragColor = texture2D(txtSampler, outTextCoord + txtDelta);
}
