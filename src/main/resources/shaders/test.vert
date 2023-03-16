#version 330

layout (location=0) in vec2 position;
layout (location=1) in vec3 color;

out vec3 outColor;

uniform mat4 projectionMatrix;
uniform mat4 modelMatrix;

void main()
{
//    vec2 pos_RatioTo1 = position / screenDimension;
//    vec2 clip_space = (pos_RatioTo1 * 2.0) - 1;
    gl_Position = projectionMatrix * modelMatrix * vec4(position, 0.0, 1.0); //vec4(clip_space * vec2(1, -1), 0.0, 1.0);
    outColor = color;
}
