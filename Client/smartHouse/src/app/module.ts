
export interface House {
    houseID? : number,
    address? : string,
    floors? : Floor[],
}

export interface UserAccount {
    userID?: number,
    fullname?: string,
    username?: string,
    password?: string,
    house?: House[],
}
export interface Floor {
    floorID? : number,
    floorName? : string,
    rooms? : Room[],
}

export interface Room {
    roomID? : number,
    roomName? : string,
    devices? : Device[],
}

export interface Device {
    deviceID?: number,
    deviceType? : DEVICE_TYPE,
    deviceName?: string,
    deviceStatus?: string,
    deviceValue?: string,
    isRuning?: boolean
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
    FAN = 'FAN'
}