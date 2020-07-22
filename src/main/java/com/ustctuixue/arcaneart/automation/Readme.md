### 魔法水晶

魔法水晶可以通过仪式制成，可以用于存储 MP、收集 MP、为世界中的法杖供应 MP。不同功能的水晶制作方法也不一样。水晶也偶尔会生成在世界中。



#### 收集型水晶

收集型水晶可以从生物群系中收集 MP，需要满足一定条件以工作。

这种水晶又可分为：

- 炎阳水晶：适应炎热的群系，温度越高效率越高
- 寒冰水晶：适应寒冷的群系，温度越低效率越高
- 繁荣水晶：适应温和、茂密、海洋群系
- 奇异水晶：适应稀有的群系，群系稀有度越高效率越高（[视频](https://www.bilibili.com/video/BV17A411b7o8)中频率 <= 0.04% 的群系）
- 熔岩水晶：汲取岩浆的热量，不必见到天空也能收集 MP 的水晶，需要下方有 9x9 的岩浆
- 虚空水晶：只能在末地工作的水晶，其下表面必须有一块黑曜石才会工作，周围的生物会减慢其工作效率

不同类型的收集型水晶在不同生物群系中的效率不同。除熔岩水晶外，收集 MP 时，水晶必须可以见到天空。

水晶每游戏刻依次检查平面内 9x9 范围内的方块，如果无法见到天空（熔岩水晶是检查下方平面是否存在岩浆源方块），或者存在其他收集水晶，那么该水晶在本次循环中不会继续产出 MP。

#### 透镜

透镜可以用来传输 MP 。从收集型水晶收集能量时，透镜必须紧挨水晶放置。透镜每隔一段时间就会将自身所储存 MP 以能量束的方式传输出去。能量束在无损传输 64 格后，将以原能量束 5%/格 的速度衰减。

透镜也可以用仪式升级，以增加发送频率、内部缓存大小以及无损传输距离。

透镜升级：

- 传送：损耗 30% 的 MP，将 MP 直接发送至另一个透镜

- 高频：增加发射频率至 1.3倍，但无损距离减少 50%

- 缓存腔：增加缓存 30%， 但无损距离减少 50%

- 持久：无损距离增加 50%，但缓存减少 30%

  

### 水晶碎片

储能水晶可以被裂解为水晶碎片，可以用于炼制 MP 药水。

- 水肺药水 + 水晶碎片 -> 魔法强化药水（暂时增加 MP 上限）
- 再生药水 + 水晶碎片 -> 魔法再生药水（提供不会被打断的 MP 回复）
- 瞬间回复药水 + 水晶碎片 -> 魔法瞬间回复药水
- + 水瓶 + 水晶碎片 -> 抗魔药水
- 魔法强化药水 + 发酵蜘蛛眼 -> 魔法弱化药水（暂时减少 MP 上限）
- 剧毒药水 + 水晶碎片 -> 魔法回复抑制药水（减慢魔法回复速度）
- 瞬间伤害药水 + 水晶碎片 -> 魔法吸收药水
- 抗魔药水 + 发酵蜘蛛眼 -> 魔抗弱化药水
- 虚弱药水 + 水晶碎片 -> 魔抗弱化药水