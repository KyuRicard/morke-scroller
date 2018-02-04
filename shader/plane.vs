#version 330 core

in vec2 position;
in vec2 tex;

out vec2 textureCoords;

uniform mat4 modelMatrix;

void main(void)
{
    gl_Position = modelMatrix * vec4(position, 0.0, 1.0);
    textureCoords = vec2((position.x + 1.0) / 2.0, 1 - (position.y + 1.0) / 2.0);
}