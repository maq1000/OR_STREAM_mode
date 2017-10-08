/*
 * OpenRemote, the Home of the Digital Home.
 * Copyright 2008-2012, OpenRemote Inc.
 *
 * See the contributors.txt file in the distribution for a
 * full listing of individual contributors.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.openremote.controller.protocol.enocean;

import org.openremote.controller.protocol.enocean.packet.radio.EspRadioTelegram;

/**
 * The interface for sending and receiving EnOcean radio telegrams.
 *
 * @author <a href="mailto:rainer@openremote.org">Rainer Hitz</a>
 */
public interface RadioInterface
{
  /**
   * Sends an EnOcean radio telegram.
   *
   * @param  rorg        radio telegram type
   *
   * @param  deviceID    sender device ID
   *
   * @param  payload     radio telegram payload data
   *
   * @param  statusByte  radio telegram status byte value
   *
   * @throws ConfigurationException
   *           if radio telegram cannot be sent because of a configuration error
   *
   * @throws ConnectionException
   *           if a connection error occurred while sending the radio telegram
   */
  void sendRadio(EspRadioTelegram.RORG rorg, DeviceID deviceID, byte[] payload, byte statusByte)
      throws ConfigurationException, ConnectionException;

  /**
   * Registers a listener for receiving EnOcean radio telegrams with
   * given sender device ID.
   *
   * @param deviceID  sender device ID
   *
   * @param listener  radio telegram listener
   */
  void addRadioListener(DeviceID deviceID, RadioTelegramListener listener);

  /**
   * Removes radio telegram listener for given sender device ID.
   *
   * @param deviceID  sender device ID
   *
   * @param listener  radio telegram listener
   */
  void removeRadioListener(DeviceID deviceID, RadioTelegramListener listener);
}
