#version 330

layout (location=0) in vec2 position;
layout (location=1) in vec2 texCoord;
layout (location=2) in vec4 color;

out vec2 outTxtCoord;
out vec4 outColor;

uniform mat4 projectionMatrix;
uniform mat4 viewMatrix;
uniform mat4 modelMatrix;
uniform vec2 txtDisplace;

void main()
{
    gl_Position = projectionMatrix * viewMatrix * modelMatrix * vec4(position, 0.0, 1.0);
    outTxtCoord = texCoord + txtDisplace;
    outColor = color;
}
