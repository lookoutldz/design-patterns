#!/bin/bash

# 定义设计模式列表
design_patterns=("Singleton" "Prototype" "FactoryMethod" "AbstractFactory" "Builder" "Adapter" "Bridge" "Composite" "Decorator" "Facade" "Flyweight" "Proxy" "ChainOfResponsibility" "Command" "Interpreter" "Iterator" "Mediator" "Memento" "Observer" "State" "Strategy" "TemplateMethod" "Visitor")

# 遍历设计模式列表并创建文件夹
for pattern in "${design_patterns[@]}"
do
    # 将模式名转换为小写
    pattern_lower=$(echo "$pattern" | tr '[:upper:]' '[:lower:]')
    # 检查文件夹是否存在
    if [ ! -d "$pattern_lower" ]; then
        # 创建文件夹
        mkdir "$pattern_lower"
    else
        echo "文件夹 '$pattern_lower' 已存在，跳过创建。"
    fi
done
