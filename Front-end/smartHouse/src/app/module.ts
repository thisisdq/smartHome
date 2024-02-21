export interface UserAccount {
    userAccountID?: number,
    fullname?: string,
    username?: string,
    password?: string,
    houses?: House[],
    temperature?: number;
    humidity?: number;
}

export interface TemperatureAndHumidity {
    temperature?: number;
    humidity?: number;
}

export interface House {
    houseID? : number,
    houseTitle? :string,
    address? : string,
    houseTemperature? : number,
    houseHumidity? : number,
    floors? : Floor[],
    userID? : number
}
export interface Floor {
    floorID? : number,
    floorName? : string,
    rooms? : Room[],
    houseID? : number,
}

export interface Room {
    roomID? : number,
    roomName? : string,
    devices? : Device[],
    floorID? : number,
}

export interface Device {
    id?: number,
    deviceType? : DEVICE_TYPE,
    deviceName?: string,
    deviceStatus?: string,
    deviceValue?: number,
    isRunning?: number,
    roomID? :number,
    devicePort? :string
}
export enum DEVICE_TYPE {
    LED = 'LED',
    DYNAMIC_LED = 'DYNAMIC_LED',
    DYNAMIC_CONTROLLER = 'DYNAMIC_CONTROLLER',
    AIR_CONDITIONAL = 'AIR_CONDITIONAL',
    TEMPERATURE= 'TEMPERATURE',
    HUMIDITY= 'HUMIDITY',
    TV = 'TV',
    CAMERA = 'CAMERA',
    SPEAKER = 'SPEAKER',
    FAN = 'FAN',
    COFFEE = 'COFFEE'
}