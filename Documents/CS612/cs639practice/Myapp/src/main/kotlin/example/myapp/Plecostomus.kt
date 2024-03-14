package example.myapp

class Plecostomus (fishColor: FishColor = AquariumFish.GoldColor):
    FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor